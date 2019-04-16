package com.daiql.mybatis.util;

/**
 *
 * 功能描述: 返回通用类
 *   -1 ： 登录验证码超时
 *   -2 :  验证码输入错误
 *
 *
 *
 *
 * @auther: daiql
 * @date:   2018/10/22 下午11:05
 */

public class JsonResult<T> {

    private Integer code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void ok() {
        this.code = 200;
        this.msg = "OK";
        this.data = null;
    }

    public void ok(String msg) {
        this.code = 200;
        this.msg = "msg";
        this.data = null;
    }

    public void errorMsg(String msg) {
        this.code = 500;
        this.msg = msg;
        this.data = null;
    }

    public static JsonResult errorException(String msg) {
        return new JsonResult(555, msg, null);
    }

    public static JsonResult errorMessage(String msg) {
        return new JsonResult(555, msg, null);
    }

    public void errorMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public JsonResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult() {

    }

    @Override
    public String toString() {
        if (data != null) {
            return "{code:"+this.getCode()+";msg:"+this.getMsg()+";" + data.getClass()+ "}";
        } else {
            return "{code:"+this.getCode()+";msg:"+this.getMsg()+";null}";
        }

    }
}
