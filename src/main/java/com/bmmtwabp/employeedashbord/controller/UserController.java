package com.bmmtwabp.employeedashbord.controller;

import com.bmmtwabp.employeedashbord.service.UserService;
import com.bmmtwabp.employeedashbord.util.ResponseVo;
import com.bmmtwabp.employeedashbord.vo.UserStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 用户-controller
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Slf4j
@Controller
@Api(tags = "用户接口")
public class UserController {

  @Resource
  private UserService userService;

  @ApiOperation(value = "小程序登录接口")
  @PostMapping("/app/login")
  @ResponseBody
  ResponseVo getUserInfo(String code, String nickName, String imgUrl) {
    log.info("js_code:  =====   " + code + "    " + nickName + "    " + imgUrl);
    UserStatusVo userStatusVo = userService.getUserInfo(code, nickName, imgUrl);
    Map map = new HashMap(2);
    map.put("userStatusVo", userStatusVo);
    return ResponseVo.ok("请求成功", map);
  }

}
