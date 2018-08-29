package com.bmmtwabp.employeedashbord.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Description: 字典项-domain
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Table(name = "dict")
@Data
public class Dict implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Column(name = "dict_type")
  private String dictType;

  @Column(name = "dict_value")
  private String dictValue;

  @Column(name = "dict_name")
  private String dictName;

}
