package com.bmmtwabp.employeedashbord.controller;

import com.bmmtwabp.employeedashbord.service.AdminUserService;
import com.bmmtwabp.employeedashbord.util.ResponseVo;
import com.bmmtwabp.employeedashbord.vo.AdminUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 首页-Controller
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Slf4j
@Controller
@Api(tags = "首页接口")
public class IndexController {

  @Resource
  private AdminUserService adminUserService;

  /**
   * 进入首页
   */
  @ApiOperation(value = "进入首页")
  @GetMapping("/index")
  ModelAndView toIndexHtml(HttpServletRequest request, Model model) {
    log.info("进入首页");
    HttpSession session = request.getSession();
    AdminUserVo adminUserVo = (AdminUserVo) session.getAttribute("adminUserInfo");
    if (adminUserVo != null) {
      model.addAttribute("adminUserInfo", adminUserVo);
      return new ModelAndView("index");
    } else {
      return new ModelAndView("login");
    }
  }

  /**
   * 引入首页的详情数据展示块
   */
  @ApiOperation(value = "引入首页的详情数据展示块")
  @GetMapping("/home")
  String getHomeHtml() {
    log.info("得到home!");
    return "index_v3";
  }

  /**
   * 进入登录页
   */
  @ApiOperation(value = "进入登录")
  @GetMapping("/login")
  String getLoginHtml() {
    log.info("进入登录!");
    return "login";
  }

  /**
   * 登录
   */
  @ApiOperation(value = "后台-登录接口")
  @PostMapping("toIndex")
  @ResponseBody
  ResponseVo login(HttpServletRequest request, String username, String password) {
    log.info("username info:    " + username + "  password info:  " + password);

    AdminUserVo adminUserVo = adminUserService.login(username, password);
    if (adminUserVo != null) {
      if (adminUserVo.getStatus() == 1) {
        return ResponseVo.warn("账号被禁用!");
      }
      HttpSession session = request.getSession();
      session.setAttribute("sessionid", session.getId());
      session.setAttribute("adminUserInfo", adminUserVo);
      return ResponseVo.ok("登录成功!!", null);
    } else {
      return ResponseVo.error("账号或密码错误!");
    }

  }

  /**
   * 登出
   */
  @ApiOperation(value = "后台-退出登录接口")
  @GetMapping("/logout")
  String logOut(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.setAttribute("adminUserInfo", null);
    log.info("清理session，退出登录:   " + System.currentTimeMillis());
    return "login";
  }

}
