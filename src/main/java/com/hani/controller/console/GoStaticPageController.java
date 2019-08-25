package com.hani.controller.console;

import com.hani.constant.CodeConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午10:40.
 * </pre>
 */
@Controller
public class GoStaticPageController {

    @RequestMapping("/console")
    public String console() {
        return "redirect:/console/index";
    }

    @RequestMapping("/console/index")
    public String index(HttpServletRequest request) {
        request.getSession().removeAttribute(CodeConstant.LOGIN_ADMIN_SESSION_KEY);
        return "console/login";
    }

    @RequestMapping("/console/pwd")
    public String pwd(HttpServletRequest request) {
        return "console/profile/pwd";
    }

    @RequestMapping("/console/news/list")
    public String list() {
        return "console/news/list";
    }

    @RequestMapping("/console/sliderImg/list")
    public String sliderImgList(){
        return "console/sliderImg/list";
    }
}
