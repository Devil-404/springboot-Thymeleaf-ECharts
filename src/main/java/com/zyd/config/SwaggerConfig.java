package com.zyd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
     @Bean
     public Docket createRestApi(){
    	  return new Docket(DocumentationType.SWAGGER_2)
    			  //组名
    			  .groupName("apiGroup1").apiInfo(apiInfo())
    			  .select()//选择那些路径和api会生成document
    			  .apis(RequestHandlerSelectors.basePackage("com.zyd.controller"))
    			  .paths(PathSelectors.any())//对所有的路径进行监控
    			  .build();
     }
     private ApiInfo apiInfo(){
    	 return new ApiInfoBuilder()
    			.title("Spring boot测试使用Swagger2构建RestFulApi")
    			.contact(new Contact("bug", "https://www.baidu.com","zyd@qq.com"))
    			.version("1.0")
    			.description("api 描述")
    			.build();
     }
}
