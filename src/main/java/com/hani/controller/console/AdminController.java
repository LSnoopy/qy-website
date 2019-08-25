package com.hani.controller.console;

import com.hani.constant.CodeConstant;
import com.hani.controller.BaseController;
import com.hani.domain.Admin;
import com.hani.service.AdminService;
import com.hani.vo.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午9:16.
 * </pre>
 */
@RestController
@RequestMapping("/console")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public Object login(HttpServletRequest request, String userName, String pwd) {
        JsonResponse jsonResponse = adminService.login(userName, pwd);
        if (jsonResponse.isSuccess()) {
            Admin admin = new Admin();
            admin.setUserName(userName);
            request.getSession().setAttribute(CodeConstant.LOGIN_ADMIN_SESSION_KEY, admin);
        }
        return jsonResponse;
    }

    @RequestMapping("/updatePwd")
    public Object updatePwd(HttpServletRequest request, String oldPwd, String newPwd) {
        Admin admin = (Admin) request.getSession().getAttribute(CodeConstant.LOGIN_ADMIN_SESSION_KEY);
        return adminService.updatePwd(admin.getUserName(), oldPwd, newPwd);
    }

    @RequestMapping("/add")
    public Object addAdmin(Admin admin) {
        adminService.addAdmin(admin);
        return successResp();
    }

}
