package com.bmmtwabp.employeedashbord.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bmmtwabp.employeedashbord.dao.HeatMapper;
import com.bmmtwabp.employeedashbord.dao.UserMapper;
import com.bmmtwabp.employeedashbord.domain.User;
import com.bmmtwabp.employeedashbord.service.UserService;
import com.bmmtwabp.employeedashbord.util.CodeUtil;
import com.bmmtwabp.employeedashbord.util.DateUtil;
import com.bmmtwabp.employeedashbord.util.HttpRequestUtil;
import com.bmmtwabp.employeedashbord.vo.UserStatusVo;
import com.sun.tools.javac.jvm.Code;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户-service实现类
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserMapper userMapper;

  @Resource
  private HeatMapper heatMapper;

  @Override
  public Integer insertUser(User user) {
    return userMapper.insertUser(user);
  }

  @Override
  public Integer getUserCountByOpenId(String openId) {
    return userMapper.getUserCountByOpenId(openId);
  }

  @Override
  public UserStatusVo getUserInfo(String code, String nickName, String imgUrl) {
    Map paramMap = new HashMap<>(5);
    paramMap.put("appid", CodeUtil.APPID);
    paramMap.put("secret", CodeUtil.APPSECRET);
    paramMap.put("js_code", code);
    paramMap.put("grant_type", CodeUtil.AUTHORIZATIONCODE);

    try {

      String result = HttpRequestUtil.httpGet(CodeUtil.WEIXINLOGIN, paramMap);
      JSONObject jsonObject = JSONObject.parseObject(result);
      String openId = (String) jsonObject.get("openid");

      UserStatusVo userStatusVo = new UserStatusVo();

      if (openId != null && !"".equals(openId)) {
        userStatusVo.setOpenId(openId);
        Integer userCount = getUserCountByOpenId(openId);

        switch (userCount) {
          /**
           * 新用户
           */
          case 0:
            User user = new User();
            user.setOpenId(openId);
            user.setNickName(nickName);
            user.setUserImgPath(imgUrl);
            Integer addInfo = insertUser(user);
            switch (addInfo) {
              case 1:
                log.info("入库成功");
                break;
              default:
                log.info("入库异常");
                break;
            }
            break;
          case 1:
            /**
             * 已有用户
             */
            log.info("openId：  " + openId);
            List<Integer> userHeatStatusList = userMapper.getUserHeatStatusByToday(openId);
            if (userHeatStatusList != null && userHeatStatusList.size() > 0) {

              Integer histroyHeatStatus = userHeatStatusList.get(userHeatStatusList.size() - 1);
              log.info("用户状态：  " + histroyHeatStatus);
              userStatusVo.setUserHeatStatus(histroyHeatStatus);
            }
            log.info("该用户已存在!!!");
            break;
          default:
            break;
        }

        log.info("userStatusVo info:    " + userStatusVo);
        return userStatusVo;

      } else {
        log.info("未获取到openId！！  ");
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      log.info("请求微信登录接口报错！！  " + e.getMessage());
    }

    return null;
  }

}
