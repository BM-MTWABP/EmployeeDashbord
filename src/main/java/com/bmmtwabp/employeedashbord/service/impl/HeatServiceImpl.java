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
  public Integer insertHeat(Heat heat) {
    Integer result = heatMapper.insertHeat(heat);
    return result;
  }

  @Override
  public Integer readyHeat(String openId) {
    return heatMapper.readyHeat(openId);
  }

  @Override
  public Integer startHeat(String openId) {
    String startTime = DateUtil.getDateTime();
    return heatMapper.startHeat(openId, startTime);
  }

  @Override
  public Integer overHeat(String openId) {
    return heatMapper.overHeat(openId);
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
