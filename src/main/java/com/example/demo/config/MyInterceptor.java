package com.example.demo.config;

import com.example.demo.common.Constants;
import com.example.demo.vo.LoginVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yi
 * @date 2020/5/2 11:08
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断登录
        if (null == request.getSession().getAttribute(Constants.USER_SESSION_KEY)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
            LoginVo loginVo= (LoginVo) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
            String path = request.getRequestURI();
            System.out.println(path);
            if (("学生".equals(loginVo.getLoginType())&&path.contains("adminer"))){
                //学生访问adminer 不放行
                response.sendRedirect(request.getContextPath() + "/index");
                return false;
            }
            if (("工作人员".equals(loginVo.getLoginType())&&!path.contains("adminer"))){
                //管理员访问其他
                response.sendRedirect(request.getContextPath() + "/adminer");
                return true;
            }
            return true;
        }
    }
}
