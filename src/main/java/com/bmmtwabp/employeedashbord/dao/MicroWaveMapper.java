package com.bmmtwabp.employeedashbord.dao;

import com.bmmtwabp.employeedashbord.domain.MicroWave;
import com.bmmtwabp.employeedashbord.vo.MicroWaveVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroWaveMapper {

  List<MicroWave> getMicroWaveInfo();

  List<MicroWaveVo> getMicroWaveVos();

  MicroWaveVo getMicroWaveInfoByZone(@Param("zoneName") String zoneName);

  Integer updateMicroWaveStatus(@Param("microwaveStatus") Integer microwaveStatus,
      @Param("zoneName") String zoneName);

}
