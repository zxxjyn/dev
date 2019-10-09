package com.amaduse.workflow_project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

/**
 * <p>Project Name : workflow_project</p>
 * <p>结果封装类</p>
 * <p>Create Date : 2019/10/9 14:01</p>
 * <p>Create User : xin.zheng</p>
 */
public class Result<T> {
    private String sign;

    private String code;

    private String message;

    private T data;

    public Result() {
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(String code, String message, T data, String sign) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.sign = sign;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
