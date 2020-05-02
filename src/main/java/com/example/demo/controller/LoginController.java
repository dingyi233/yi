package com.example.demo.controller;

import com.example.demo.service.LoginService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Result do_login(LoginVo loginVo) {
        System.out.println(loginVo);
        boolean checkLogin = loginService.checkLogin(loginVo);
        if (checkLogin){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("账号密码有误");
        }

    }
}
