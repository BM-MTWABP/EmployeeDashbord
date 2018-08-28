package com.bmmtwabp.employeedashbord.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Description: 用户-domain
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Table(name = "user")
@Data
public class User {

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Id
  @Column(name = "open_id")
  private String openId;

  @Id
  @Column(name = "nickname")
  private String nickName;

  @Id
  @Column(name = "user_img")
  private String userImgPath;

  @Id
  @Column(name = "zone")
  private Integer zone;

}
