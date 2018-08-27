package com.bmmtwabp.employeedashbord.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @Description: 管理员-domain
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Table(name = "admin_user")
@Data
public class AdminUser implements Serializable {

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Id
  @Column(name = "username")
  private String username;

  @Id
  @Column(name = "password")
  private String password;

  @Id
  @Column(name = "email")
  private String email;

  @Id
  @Column(name = "type")
  private Integer type;

  @Id
  @Column(name = "status")
  private Integer status;

  @Id
  @Column(name = "img_path")
  private String imgPath;

  @Id
  @Column(name = "create_time")
  private String createTime;

}

