package com.amaduse.workflow_project.controller.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Project Name : workflow_project</p>
 * <p>测试 Controller</p>
 * <p>Create Date : 2019/10/8 11:40</p>
 * <p>Create User : xin.zheng</p>
 */
@RestController
@RequestMapping("/test")
@Api("Test Controller")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("get")
    @ApiOperation("This is test function")
    @ResponseBody
    public String test(@RequestParam String str){
        logger.info(str);
        return str;
    }
}
