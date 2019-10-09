package com.amaduse.workflow_project.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    //swagger 分组显示， swagger2 默认选中显示 最下面一列
    @Bean
    public Docket createRestActuator() {
        return new Docket(DocumentationType.SWAGGER_2).protocols(Sets.newHashSet("http","https")) // 协议，http或https
                .groupName("Actuator Group")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(""))
                .paths(PathSelectors.regex("/actuator/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST接口定义")
                .version("1.0")
                .description("用于测试RESTful API")
                .build();
    }

    @Bean
    public Docket testRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).protocols(Sets.newHashSet("http","https")) // 协议，http或https
                .groupName("Test Group")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.amaduse.workflow_project"))
                .paths(PathSelectors.regex("/test/.*"))
                .build();
    }
    @Bean
    public Docket baseRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).protocols(Sets.newHashSet("http","https")) // 协议，http或https
                .groupName("Base Group")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.amaduse.workflow_project"))
                .paths(PathSelectors.regex("/user/.*|role/.*"))
                .build();
    }



}
