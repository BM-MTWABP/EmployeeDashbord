package com.bmmtwabp.employeedashbord.service;

import com.bmmtwabp.employeedashbord.vo.AdminUserVo;
import org.apache.ibatis.annotations.Param;

public interface AdminUserService {

  AdminUserVo login(@Param("username") String username, @Param("password") String password);

}
