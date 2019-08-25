package com.hani.controller.console;

import com.hani.constant.CodeConstant;
import com.hani.domain.Admin;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/19 下午7:45.
 * </pre>
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Set<String> excludeUrls;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        if (isExclude(url)) {
            return true;
        }
        Admin admin = (Admin) request.getSession().getAttribute(CodeConstant.LOGIN_ADMIN_SESSION_KEY);
        if (admin == null) {
            response.sendRedirect("/console/index");
            return false;
        }
        return true;
    }

    private boolean isExclude(String url) {
        if (CollectionUtils.isNotEmpty(excludeUrls)) {
            return excludeUrls.contains(url);
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    public Set<String> getExcludeUrls() {
        return excludeUrls;
    }

    public void setExcludeUrls(Set<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }
}
