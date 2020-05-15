package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yi
 * @date 2020/5/2 11:06
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有排除静态资源和登录页面
        //还可以配置为拦截部分
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/user/login","/login","/js/**","/css/**","/images/**","/fonts/**");
    }
}
