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
@RequestMapping("/farmcase")
public class FarmcaseController extends BaseController {

    @RequestMapping("/list")
    public String list() {
        return "website/farmcase/list";
    }
}
