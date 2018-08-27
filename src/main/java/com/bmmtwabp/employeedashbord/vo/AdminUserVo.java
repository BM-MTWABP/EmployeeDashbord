package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class AdminUserVo implements Serializable {

  private Long id;

  private String username;

  private String email;

  private Integer type;

  private String adminType;

  private Integer status;

  private String imgPath;

}


