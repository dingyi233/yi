package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.service.LoginService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/1 23:59
 */
@Controller
public class UserController {
    @Autowired
    private LoginService loginService;

    /**
     * 跳转登陆页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录的实现逻辑
     * @param loginVo
     * @param httpSession
     * @return
     */
    @PostMapping("/user/login")
    @ResponseBody
    public Result userLogin(LoginVo loginVo, HttpSession httpSession) {
        System.out.println(loginVo);
        boolean checkLogin = loginService.checkLogin(loginVo);
        if (checkLogin){
            //设置session
            httpSession.setAttribute(Constants.SER_SESSION_KEY,loginVo);
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("账号密码有误");
        }
    }
    @GetMapping("/logout")
    public String userLogout(HttpSession httpSession){
        //清除session
        httpSession.removeAttribute(Constants.SER_SESSION_KEY);
        //返回登陆页面
        return "login";
    }
}
