package com.bmmtwabp.employeedashbord.controller;

import com.bmmtwabp.employeedashbord.service.AdminUserService;
import com.bmmtwabp.employeedashbord.util.ResponseVo;
import com.bmmtwabp.employeedashbord.vo.AdminUserVo;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class IndexController {

  @Resource
  private AdminUserService adminUserService;

  /**
   * 进入首页
   */
  @RequestMapping("/index")
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
  @RequestMapping("/home")
  String getHomeHtml() {
    log.info("得到home!");
    return "index_v3";
  }

  @RequestMapping("/login")
  String getLoginHtml() {
    log.info("进入登录!");
    return "login";
  }

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
      return ResponseVo.ok("登录成功!!");
    } else {
      return ResponseVo.error("账号或密码错误!");
    }

  }

  /**
   * 登出
   */
  @RequestMapping("/logout")
  String logOut(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.setAttribute("adminUserInfo", null);
    log.info("清理session，退出登录:   " + System.currentTimeMillis());
    return "login";
  }

}
