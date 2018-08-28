package com.bmmtwabp.employeedashbord.service;

import com.bmmtwabp.employeedashbord.domain.User;
import com.bmmtwabp.employeedashbord.vo.UserStatusVo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

  Integer insertUser(User user);

  Integer getUserCountByOpenId(String openId);

  UserStatusVo getUserInfo(String code, String nickName, String imgUrl);

}
