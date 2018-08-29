package com.bmmtwabp.employeedashbord.service;

import com.bmmtwabp.employeedashbord.domain.MicroWave;
import com.bmmtwabp.employeedashbord.vo.MicroWaveVo;
import java.util.List;

public interface MicrowaveService {

  List<MicroWave> getMicroWaveInfo();

  List<MicroWaveVo> getMicroWaveVos();

  MicroWaveVo getMicroWaveInfoByZone(String zoneName);

}
