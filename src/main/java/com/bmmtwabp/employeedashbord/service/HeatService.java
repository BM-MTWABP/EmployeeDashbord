package com.bmmtwabp.employeedashbord.service;

import com.bmmtwabp.employeedashbord.domain.Heat;
import com.bmmtwabp.employeedashbord.vo.HeatVo;
import com.bmmtwabp.employeedashbord.vo.QueryHeatVo;
import java.util.List;

public interface HeatService {

  List<Heat> getHeatInfo();

  Integer insertHeat(Heat heat);

  Integer startHeat(String openId);

  Integer overHeat(String openId);

  List<HeatVo> getHeatVoList(QueryHeatVo queryHeatVo);

  List<HeatVo> getHeatListForApp(String zoneName);

  Integer getHistoryHeatSum(String zoneName);

}
