package com.bmmtwabp.employeedashbord.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Description: 热饭-domain
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Table(name = "heating")
@Data
public class Heat implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Id
  @Column(name = "open_id")
  private String openId;

  @Id
  @Column(name = "start_time")
  private String startTime;

  @Id
  @Column(name = "end_time")
  private String endTime;

  @Id
  @Column(name = "heat_status")
  private Integer heatStatus;

  @Id
  @Column(name = "zone")
  private String zone;

}
