package com.amaduse.workflow_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
@MapperScan("com.amaduse.workflow_project")
public class WorkflowProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkflowProjectApplication.class, args);
    }
}
