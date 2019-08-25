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
@RequestMapping("/cooperation")
public class CooperationController extends BaseController {

    @RequestMapping("/cooperate")
    public String cooperate() {
        return "website/cooperation/cooperate";
    }
}
