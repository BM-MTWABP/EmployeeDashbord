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

  Heat getHeatInfoByOpenId(@Param("openId") String openId);

  Integer insertHeat(Heat heat);

  Integer readyHeat(@Param("openId") String openId);

  Integer startHeat(@Param("openId") String openId, @Param("startTime") String startTime);

  Integer overHeat(@Param("openId") String openId, @Param("endTime") String endTime);

  List<HeatVo> getHeatVoList(QueryHeatVo queryHeatVo);

  List<HeatVo> getHeatListForApp(@Param("zoneName") String zoneName);

  String getWaitFirstHeatUserOpenId(@Param("zoneName") String zoneName);

  Integer getHistoryHeatSum(@Param("zoneName") String zoneName);

  Integer getWaitHeatSum(@Param("zoneName") String zoneName);

  Integer getReadyHeatSum(@Param("zoneName") String zoneName);

  Integer getHeatingSum(@Param("zoneName") String zoneName);

  String getHeatingNickName(@Param("zoneName") String zoneName);

}
