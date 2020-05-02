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
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public Result do_login(LoginVo loginVo, HttpSession httpSession) {
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
}
