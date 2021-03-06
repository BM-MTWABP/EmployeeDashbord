package com.bmmtwabp.employeedashbord.dao;

import com.bmmtwabp.employeedashbord.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户User-dao
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Repository
public interface UserMapper {

  Integer insertUser(User user);

  Integer getUserCountByOpenId(@Param("openId") String openId);

  List<Integer> getUserHeatStatusByToday(@Param("openId") String openId);

}
