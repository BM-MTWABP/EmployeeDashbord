package com.bmmtwabp.employeedashbord.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 微波炉-domain
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/29
 */
@Table(name = "microwave")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MicroWave implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Id
  @Column(name = "microwave_name")
  private String microwaveName;

  @Id
  @Column(name = "microwave_status")
  private Integer microwaveStatus;

  @Id
  @Column(name = "zone")
  private String zone;


}
