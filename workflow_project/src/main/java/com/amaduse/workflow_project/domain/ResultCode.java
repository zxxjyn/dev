package com.amaduse.workflow_project.domain;

/**
 * @program: activiti workflow
 * @description: 响应结果码枚举类
 * @author: SettleACG
 * @create: 2018-09-07 16:39
 **/
public enum ResultCode {
    SUCCESS("0","请求成功!"),
    PARAM_ERR("1","请求失败，参数有误"),
    EXCEPTION("-1","系统异常"),
    NO_REGIST_GTAPPID("0001","该应用未注册个推密钥"),
    NO_REGIST_DEVICE("0002","该设备未注册");

    private String code;

    private String desc;

    ResultCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "code='" + code + '\'' +
                ", desc='" + desc + '\''
               ;
    }
}
