package com.hani.vo;

import java.io.Serializable;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午9:23.
 * </pre>
 */
public class JsonResponse<T> implements Serializable {

    public static final String SUCCESS = "200";
    public static final String FAIL = "300";
    public static final String ERROR = "500";

    private String result;
    private String msg;

    private T data;

    public JsonResponse() {
    }

    public JsonResponse(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public JsonResponse(String result, String msg, T data) {
        this.result = result;
        this.msg = msg;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public boolean isSuccess() {
        return SUCCESS.equals(this.result);
    }
}
