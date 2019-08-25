package com.hani.controller.website;

import com.hani.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/2/18 上午11:00.
 * </pre>
 */
@Controller
@RequestMapping("/about")
public class AboutController extends BaseController {

    @RequestMapping("/us")
    public String us() {
        return "website/about/us";
    }
}
