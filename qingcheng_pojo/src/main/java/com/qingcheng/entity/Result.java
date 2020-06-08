package com.qingcheng.entity;

import java.io.Serializable;

public class Result implements Serializable {

    //返回业务代码： 0 代表成功 1代表业务失败
    private Integer code;
    //返回业务信息
    private String msg;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
        this.code = 0;
        this.msg = "成功保存";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
