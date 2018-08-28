package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class HeatVo implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  private Long heatId;

  private String openId;

  private String nickName;

  private String imgUrl;

  /**
   * 热饭准备时间
   */
  private String readyTime;

  /**
   * 热饭开始时间
   */
  private String startTime;

  /**
   * 热饭结束时间
   */
  private String endTime;

  /**
   * 状态名称
   */
  private String heatStatusName;

  /**
   * 区域名称
   */
  private String zoneName;

}
