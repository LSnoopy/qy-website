package com.hani.controller;

import com.hani.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午2:08.
 * </pre>
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private AdminService AdminService;

    @RequestMapping("/hi")
    public String test(HttpServletRequest request) {
        request.setAttribute("user", "你好");
        return "test";
    }

}
