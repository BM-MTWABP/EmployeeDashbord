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
 * @Description: 用户-domain
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  @Id
  @GeneratedValue(generator = "JDBC")
  @Column(name = "id")
  private Long id;

  @Column(name = "open_id")
  private String openId;

  @Column(name = "nickname")
  private String nickName;

  @Column(name = "user_img")
  private String userImgPath;

  @Column(name = "zone")
  private Integer zone;

}
