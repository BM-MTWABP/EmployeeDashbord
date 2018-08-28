package com.bmmtwabp.employeedashbord.util;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description: 分页查询对象
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@Data
public class QueryRequest implements Serializable {

  private static final long serialVersionUID = -4869594085374385813L;

  private int pageSize;
  private int pageNum;

}
