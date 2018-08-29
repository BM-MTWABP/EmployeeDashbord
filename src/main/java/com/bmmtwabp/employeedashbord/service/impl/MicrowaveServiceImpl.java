package com.bmmtwabp.employeedashbord.service.impl;

import com.bmmtwabp.employeedashbord.dao.MicroWaveMapper;
import com.bmmtwabp.employeedashbord.domain.MicroWave;
import com.bmmtwabp.employeedashbord.service.MicrowaveService;
import com.bmmtwabp.employeedashbord.vo.MicroWaveVo;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MicrowaveServiceImpl implements MicrowaveService {

  @Resource
  private MicroWaveMapper microWaveMapper;

  @Override
  public List<MicroWave> getMicroWaveInfo() {
    return microWaveMapper.getMicroWaveInfo();
  }

  @Override
  public List<MicroWaveVo> getMicroWaveVos() {
    return microWaveMapper.getMicroWaveVos();
  }

  @Override
  public MicroWaveVo getMicroWaveInfoByZone(String zoneName) {
    return microWaveMapper.getMicroWaveInfoByZone(zoneName);
  }

}
