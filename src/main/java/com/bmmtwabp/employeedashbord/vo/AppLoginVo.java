package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description: 小程序登录-Vo
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/29
 */
@Data
public class AppLoginVo implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  private String code;

  private String nickName;

  private String imgUrl;

}
