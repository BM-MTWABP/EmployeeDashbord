package com.bmmtwabp.employeedashbord.controller;

import com.bmmtwabp.employeedashbord.domain.Heat;
import com.bmmtwabp.employeedashbord.service.HeatService;
import com.bmmtwabp.employeedashbord.util.QueryRequest;
import com.bmmtwabp.employeedashbord.util.ResponseVo;
import com.bmmtwabp.employeedashbord.vo.HeatVo;
import com.bmmtwabp.employeedashbord.vo.QueryHeatVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: -Controller
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Slf4j
@Controller
@Api(tags = "热饭接口")
public class HeatController extends BaseController {

  @Resource
  private HeatService heatService;

  /**
   * 进入热饭页面
   */
  @ApiOperation(value = "后台-进入热饭列表页面")
  @GetMapping("/heat")
  String toHeatingHtml() {
    log.info("进入热饭页面!");
    return "heating";
  }

  /**
   * 获取热饭列表接口
   */
  @ApiOperation(value = "后台-热饭列表接口")
  @GetMapping("/heats")
  @ResponseBody
  Map<String, Object> getHeatVoList(QueryRequest request, QueryHeatVo queryHeatVo) {
    log.info("page: ---  " + request.getPageNum() + "   ---  " + request.getPageSize());
    log.info(
        "heatVo: ---  " + queryHeatVo.getHeatStatusValue() + "   ---   " + queryHeatVo.getNickName()
            + "   ---  "
            + queryHeatVo.getZoneName());

    PageHelper.startPage(request.getPageNum(), request.getPageSize());
    List<HeatVo> heatVoList = heatService.getHeatVoList(queryHeatVo);
    PageInfo<HeatVo> pageInfo = new PageInfo<>(heatVoList);
    log.info("response info: ---  " + pageInfo);
    return getDataTable(pageInfo);
  }

  /**
   * 获取历史数据-总热饭人数
   */
  @ApiOperation(value = "后台-获取历史数据-总热饭人数")
  @GetMapping("/heat/history/{zoneName}")
  @ResponseBody
  ResponseVo getHistoryHeatSum(@PathVariable String zoneName) {
    log.info("zoneName info：  " + zoneName);

    if (zoneName == null || "".equals(zoneName)) {
      return ResponseVo.warn("传参为null！");
    }

    Integer heatSum = heatService.getHistoryHeatSum(zoneName);
    return ResponseVo.ok("获取成功!", heatSum);
  }

  /**
   * 小程序-进入热饭等待队列
   */
  @ApiOperation(value = "进入热饭等待队列")
  @PostMapping("/app/heat")
  @ResponseBody
  ResponseVo insertHeatInfo(@RequestBody Heat heat) {
    log.info("新增热饭 info：  " + heat);

    if (heat == null) {
      return ResponseVo.warn("新增对象为null!");
    }

    Integer result = heatService.insertHeat(heat);
    if (result == 1) {
      return ResponseVo.ok("新增成功！！", null);
    } else {
      return ResponseVo.error("新增失败~~");
    }

  }

  /**
   * 小程序-开始热饭
   */
  @ApiOperation(value = "开始热饭")
  @PutMapping("/app/heat/start")
  @ResponseBody
  ResponseVo startHeat(String openId) {
    log.info("startHeat openid info:    " + openId);

    if (openId == null || "".equals(openId)) {
      return ResponseVo.error("openid未传入!!!");
    }

    Integer result = heatService.startHeat(openId);
    if (result == 1) {
      return ResponseVo.ok("您可以热饭了！", null);
    } else {
      return ResponseVo.error("您热饭出现点儿问题哦~~");
    }
  }

  /**
   * 小程序-结束热饭
   */
  @ApiOperation(value = "结束热饭")
  @PutMapping("/app/heat/over")
  @ResponseBody
  ResponseVo overHeat(String openId) {
    log.info("overHeat openid info:    " + openId);

    if (openId == null || "".equals(openId)) {
      return ResponseVo.error("openid未传入!!!");
    }

    Integer result = heatService.overHeat(openId);
    if (result == 1) {
      return ResponseVo.ok("您的饭好了！用餐愉快!!", null);
    } else {
      return ResponseVo.error("您未正常结束热饭~~");
    }

  }

  /**
   * 小程序-获取结束热饭列表
   */
  @ApiOperation(value = "小程序-热饭列表")
  @GetMapping("/app/heats")
  @ResponseBody
  ResponseVo getHeatListForApp(String zoneName) {
    log.info("zone:   " + zoneName);

    if (zoneName == null || "".equals(zoneName)) {
      return ResponseVo.error("zoneName未传入!!!");
    }

    List<HeatVo> heatVoList = heatService.getHeatListForApp(zoneName);
    if (heatVoList != null && heatVoList.size() > 0) {
      return ResponseVo.ok("获取成功", heatVoList);
    } else {
      return ResponseVo.ok("列表为空", null);
    }
  }

}
