package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description: 热饭列表查询对象
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Data
public class QueryHeatVo implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  private String nickName;

  private Integer heatStatusValue;

  private String zoneName;

}
