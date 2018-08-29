package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description: 微波炉-Vo
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/29
 */
@Data
public class MicroWaveVo implements Serializable {

  private Long mwId;

  private String microwaveName;

  private Integer microwaveStatus;

  private String microwaveStatusName;

  private String zoneName;

}
