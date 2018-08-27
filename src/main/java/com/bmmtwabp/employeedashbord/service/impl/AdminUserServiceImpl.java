package com.bmmtwabp.employeedashbord.service.impl;

import com.bmmtwabp.employeedashbord.dao.AdminUserMapper;
import com.bmmtwabp.employeedashbord.service.AdminUserService;
import com.bmmtwabp.employeedashbord.vo.AdminUserVo;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {

  @Resource
  private AdminUserMapper adminUserMapper;

  /**
   * 登录
   */
  @Override
  public AdminUserVo login(String username, String password) {

    AdminUserVo adminUserVo = adminUserMapper.login(username, password);
    log.info("登录用户：" + adminUserVo);

    return adminUserVo;
  }
}
