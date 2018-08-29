package com.bmmtwabp.employeedashbord.service.impl;

import com.bmmtwabp.employeedashbord.dao.HeatMapper;
import com.bmmtwabp.employeedashbord.domain.Heat;
import com.bmmtwabp.employeedashbord.service.HeatService;
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
  public Integer insertHeat(Heat heat) {
    Integer result = heatMapper.insertHeat(heat);
    return result;
  }

  @Override
  public Integer startHeat(String openId) {
    String startTime = DateUtil.getDateTime();
    return heatMapper.startHeat(openId, startTime);
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
    Integer result = heatMapper.overHeat(openId);
    if (result == 1) {
      log.info("结束热饭成功！");
      String waitHeatUserOpenId = heatMapper.getWaitFirstHeatUserOpenId(zoomName);
      if (waitHeatUserOpenId != null) {
        heatMapper.readyHeat(waitHeatUserOpenId);
        log.info("openid:  " + waitHeatUserOpenId + "   进入准备热饭状态!!");
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
