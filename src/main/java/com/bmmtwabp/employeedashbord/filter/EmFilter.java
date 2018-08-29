//package com.bmmtwabp.employeedashbord.filter;
//
//import com.bmmtwabp.employeedashbord.vo.AdminUserVo;
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.annotation.Order;
//
///**
// * @Description: 拦截器
// * @Param:
// * @return:
// * @Author: fenghouzhi
// * @Date: 2018/8/29
// */
//@Slf4j
//@Order(1)
//@WebFilter(filterName = "emFilter", urlPatterns = {"/*"})
//public class EmFilter implements Filter {
//
//  @Override
//  public void init(FilterConfig filterConfig) throws ServletException {
//    log.info("emFilter 初始化");
//  }
//
//  @Override
//  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//      FilterChain filterChain) throws IOException, ServletException {
//    log.info("emFilter 请求处理");
//    HttpServletRequest request = (HttpServletRequest) servletRequest;
//    HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//    HttpSession session = request.getSession();
//    AdminUserVo adminUserVo = (AdminUserVo) session.getAttribute("adminUserInfo");
//    log.info(
//        "adminUserVo:  " + adminUserVo + "  ----ssss   " + ((HttpServletRequest) servletRequest).getContextPath());
//    if (adminUserVo == null) {
//      response.sendRedirect(request.getContextPath() + "/login");
//      return;
//    } else {
//      filterChain.doFilter(servletRequest, servletResponse);
//    }
//  }
//
//  @Override
//  public void destroy() {
//    log.info("emFilter 销毁");
//  }
//}
