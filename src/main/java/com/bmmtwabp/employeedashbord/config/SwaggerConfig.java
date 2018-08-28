package com.bmmtwabp.employeedashbord.config;

import springfox.documentation.service.Contact;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: swagger配置类
 * @Param:
 * @return:
 * @Author: fenghouzhi
 * @Date: 2018/8/28
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

  @Value(value = "${swagger.enabled}")
  Boolean swaggerEnabled;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        // 是否开启
        .enable(swaggerEnabled).select()
        // 扫描的路径包
        .apis(RequestHandlerSelectors.basePackage("com.bmmtwabp.employeedashbord.controller"))
        // 指定路径处理PathSelectors.any()代表所有的路径
        .paths(PathSelectors.any()).build().pathMapping("");
  }


  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("EmployeeService API")
        .description("小智")
        // 作者信息
        .contact(new Contact("fhz", "https://loser_xiaozhi.coding.me/blog/", "13718913664@163.com"))
        .version("1.0.0")
        .build();
  }

}
