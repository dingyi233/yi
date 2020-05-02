package com.example.demo.config;

import com.example.demo.common.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 11:08
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断登录
        if (null == request.getSession().getAttribute(Constants.SER_SESSION_KEY)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
            return true;
        }
    }
}
