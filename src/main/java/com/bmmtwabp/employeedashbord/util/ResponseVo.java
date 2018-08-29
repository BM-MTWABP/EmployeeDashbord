package com.bmmtwabp.employeedashbord.util;

import java.util.HashMap;

public class ResponseVo extends HashMap<String, Object> {

  private static final long serialVersionUID = -8713837118340960775L;

  /**
   * 成功
   */
  private static final Integer SUCCESS = 200;

  /**
   * 警告
   */
  private static final Integer WARN = 201;

  /**
   * 异常 失败
   */
  private static final Integer FAIL = 500;

  public ResponseVo() {
    put("code", SUCCESS);
    put("msg", "操作成功");
  }

  public static ResponseVo error(Object msg) {
    ResponseVo responseVo = new ResponseVo();
    responseVo.put("code", FAIL);
    responseVo.put("msg", msg);
    return responseVo;
  }

  public static ResponseVo warn(Object msg) {
    ResponseVo responseVo = new ResponseVo();
    responseVo.put("code", WARN);
    responseVo.put("msg", msg);
    return responseVo;
  }

  public static ResponseVo ok(Object msg, Object data) {
    ResponseVo responseVo = new ResponseVo();
    responseVo.put("code", SUCCESS);
    responseVo.put("msg", msg);
    responseVo.put("data", data);
    return responseVo
        ;
  }

  public static ResponseVo ok() {
    return new ResponseVo();
  }

  public static ResponseVo error() {
    return ResponseVo.error("");
  }

  @Override
  public ResponseVo put(String key, Object value) {
    super.put(key, value);
    return this;
  }
}
