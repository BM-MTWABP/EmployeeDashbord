package com.bmmtwabp.employeedashbord.dao;

import com.bmmtwabp.employeedashbord.domain.AdminUser;
import com.bmmtwabp.employeedashbord.vo.AdminUserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 管理员-dao
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Repository
public interface AdminUserMapper {

  AdminUserVo login(@Param("username") String username, @Param("password") String password);

}