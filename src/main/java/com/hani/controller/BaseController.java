package com.hani.controller;

import com.hani.vo.JsonResponse;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午9:20.
 * </pre>
 */
public class BaseController {

    protected JsonResponse successResp() {
        return new JsonResponse(JsonResponse.SUCCESS, "success");
    }

    protected <T> JsonResponse<T> successResp(T data) {
        return new JsonResponse<T>(JsonResponse.SUCCESS, "success", data);
    }

    protected JsonResponse failResp(String msg) {
        return new JsonResponse(JsonResponse.FAIL, msg);
    }

    protected JsonResponse errorResp(String msg) {
        return new JsonResponse<>(JsonResponse.ERROR, msg);
    }

}
