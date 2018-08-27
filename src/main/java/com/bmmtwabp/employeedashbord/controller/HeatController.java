package com.bmmtwabp.employeedashbord.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: -Controller
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Slf4j
@Controller
public class HeatController {

  /**
   * 进入热饭列表
   */
  @RequestMapping("/heat")
  String toHeatingHtml() {
    log.info("进入热饭列表!!");
    return "heating";
  }

}
