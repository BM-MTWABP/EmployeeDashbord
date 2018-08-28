package com.bmmtwabp.employeedashbord.dao;

import com.bmmtwabp.employeedashbord.domain.Heat;
import com.bmmtwabp.employeedashbord.vo.HeatVo;
import com.bmmtwabp.employeedashbord.vo.QueryHeatVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeatMapper {

  List<Heat> getHeatInfo();

  Integer insertHeat(Heat heat);

  Integer readyHeat(@Param("openId") String openId);

  Integer startHeat(@Param("openId") String openId, @Param("startTime") String startTime);

  Integer overHeat(@Param("openId") String openId);

  List<HeatVo> getHeatVoList(QueryHeatVo queryHeatVo);

  List<HeatVo> getHeatListForApp(@Param("zoneName") String zoneName);

}
