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

  private static final long serialVersionUID = -3245478690496182643L;

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "admin_nickname")
  private String adminNickName;

  @Column(name = "email")
  private String email;

  @Column(name = "type")
  private Integer type;

  @Column(name = "status")
  private Integer status;

  @Column(name = "img_path")
  private String imgPath;

  @Column(name = "create_time")
  private String createTime;

}

