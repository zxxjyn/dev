package com.amaduse.workflow_project.controller.base;

import com.amaduse.workflow_project.domain.Result;
import com.amaduse.workflow_project.domain.ResultCode;
import com.amaduse.workflow_project.service.base.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project Name : workflow_project</p>
 * <p>用户模块</p>
 * <p>Create Date : 2019/10/9 13:45</p>
 * <p>Create User : xin.zheng</p>
 */
@RestController
@RequestMapping("/user")
@Api("用户控制")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    @ApiOperation("用户查询")
    public Result<Map<String, Object>> getUserInfo() {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("list", "This is list");
        return new Result<>(
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getDesc(),
                resMap
        );
    }
}
