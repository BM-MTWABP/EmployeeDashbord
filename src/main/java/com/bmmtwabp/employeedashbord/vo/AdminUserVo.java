package com.bmmtwabp.employeedashbord.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class AdminUserVo implements Serializable {

  private static final long serialVersionUID = -3245478690496182643L;

  private Long id;

  private String username;

  private String email;

  private Integer type;

  private String adminType;

  private Integer status;

  private String imgPath;

}


