package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description: 小程序返回对象
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Data
public class UserStatusVo implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  private String openId;

  private Integer userHeatStatus;

}
