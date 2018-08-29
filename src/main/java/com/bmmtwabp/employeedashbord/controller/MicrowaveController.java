package com.bmmtwabp.employeedashbord.controller;

import com.bmmtwabp.employeedashbord.service.MicrowaveService;
import com.bmmtwabp.employeedashbord.util.ResponseVo;
import com.bmmtwabp.employeedashbord.vo.MicroWaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 微波炉-controller
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/29
 */
@Slf4j
@Controller
@Api(tags = "微波炉接口")
public class MicrowaveController extends BaseController {

  @Resource
  private MicrowaveService microwaveService;

  /**
   * 获取微波炉列表接口
   */
  @ApiOperation(value = "后台-微波炉列表接口")
  @GetMapping("/microsofts")
  @ResponseBody
  ResponseVo getMicroWaveVos() {

    List<MicroWaveVo> microWaveVoList = microwaveService.getMicroWaveVos();
    if (microWaveVoList != null && microWaveVoList.size() > 0) {
      return ResponseVo.ok("获取数据成功!", microWaveVoList);
    } else {
      return ResponseVo.warn("数据为空!");
    }

  }

  /**
   * 获取微波炉具体信息
   */
  @ApiOperation(value = "后台-微波炉具体信息")
  @GetMapping("/microsoft/{zoneName}")
  @ResponseBody
  ResponseVo getMicroWaveVos(@PathVariable String zoneName) {

    log.info("传入的微波炉ID info:    " + zoneName);
    zoneName = zoneName.trim();
    MicroWaveVo microWaveVo = microwaveService.getMicroWaveInfoByZone(zoneName);
    if (microWaveVo != null) {
      return ResponseVo.ok("获取数据成功!", microWaveVo);
    } else {
      return ResponseVo.warn("数据为空!");
    }

  }

}
