package com.bmmtwabp.employeedashbord.service.impl;

import com.bmmtwabp.employeedashbord.dao.HeatMapper;
import com.bmmtwabp.employeedashbord.dao.MicroWaveMapper;
import com.bmmtwabp.employeedashbord.domain.Heat;
import com.bmmtwabp.employeedashbord.service.HeatService;
import com.bmmtwabp.employeedashbord.util.CodeUtil;
import com.bmmtwabp.employeedashbord.util.DateUtil;
import com.bmmtwabp.employeedashbord.vo.HeatVo;
import com.bmmtwabp.employeedashbord.vo.QueryHeatVo;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: 热饭-实现类
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Slf4j
@Service
public class HeatServiceImpl implements HeatService {

  @Resource
  private HeatMapper heatMapper;

  @Resource
  private MicroWaveMapper microWaveMapper;


  @Override
  public List<Heat> getHeatInfo() {
    return heatMapper.getHeatInfo();
  }

  @Override
  public List<HeatVo> getHeatListForApp(String zoneName) {
    List<HeatVo> heatVoList = heatMapper.getHeatListForApp(zoneName);
    return heatVoList;
  }

  @Override
  public Integer getHistoryHeatSum(String zoneName) {
    return heatMapper.getHistoryHeatSum(zoneName);
  }

  @Override
  public Integer getWaitHeatSum(String zoneName) {
    return heatMapper.getWaitHeatSum(zoneName);
  }

  @Override
  public String getHeatingNickName(String zoneName) {
    return heatMapper.getHeatingNickName(zoneName);
  }

  @Override
  public Integer insertHeat(Heat heat) {
    Integer result = heatMapper.insertHeat(heat);

    Integer waitHeatSum = heatMapper.getWaitHeatSum(heat.getZone());
    Integer readyHeatSum = heatMapper.getReadyHeatSum(heat.getZone());
    Integer heatingSum = heatMapper.getHeatingSum(heat.getZone());

    log.info("等待人数：   " + waitHeatSum);
    log.info("准备人数：   " + readyHeatSum);
    log.info("热饭人数：   " + heatingSum);

    if (waitHeatSum == 0 && readyHeatSum == 0 && heatingSum == 0) {
      result = 1;
    }
    return result;
  }

  @Override
  public Integer startHeat(String openId) {

    String startTime = DateUtil.getDateTime();

    Integer result = heatMapper.startHeat(openId, startTime);
    if (result == 1) {
      Heat heat = heatMapper.getHeatInfoByOpenId(openId);
      String zoneName = heat.getZone();
      microWaveMapper.updateMicroWaveStatus(CodeUtil.MICROWAVEUSED, zoneName);
    }
    return result;
  }

  @Override
  public Integer overHeat(String openId) {
    Heat heat = heatMapper.getHeatInfoByOpenId(openId);

    if (heat == null) {
      log.info("未找到当前用户热饭记录");
      return 0;
    }

    String zoomName = heat.getZone();
    log.info("热饭区域:   " + zoomName);

    String endTime = DateUtil.getDateTime();

    Integer result = heatMapper.overHeat(openId, endTime);
    if (result == 1) {

      microWaveMapper.updateMicroWaveStatus(CodeUtil.MICROWAVENOTUSED, zoomName);
      log.info("结束热饭成功！微波炉状态设置为info：    未使用");

      String waitHeatUserOpenId = heatMapper.getWaitFirstHeatUserOpenId(zoomName);
      if (waitHeatUserOpenId != null) {
        heatMapper.readyHeat(waitHeatUserOpenId);
        log.info("openid:  " + waitHeatUserOpenId + "   进入准备热饭状态");
      } else {
        log.info("当前没有等待热饭的人！");
      }
      return result;

    } else {
      log.info("结束热饭失败！");
      return 0;
    }

  }

  @Override
  public List<HeatVo> getHeatVoList(QueryHeatVo queryHeatVo) {
    queryHeatVo.setNickName(queryHeatVo.getNickName().trim());
    List<HeatVo> heatVoList = heatMapper.getHeatVoList(queryHeatVo);
    return heatVoList;
  }

  private List<HeatVo> formatHeatVoList(List<HeatVo> heatVoList) {

    return heatVoList;
  }
}
