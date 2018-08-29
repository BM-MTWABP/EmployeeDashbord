package com.bmmtwabp.employeedashbord;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 项目启动类
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/27
 */
@Slf4j
@MapperScan("com.bmmtwabp.employeedashbord.dao")
@SpringBootApplication
public class EmployeedashbordApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeedashbordApplication.class, args);
    log.info("项目启动完成！！");
  }

}
