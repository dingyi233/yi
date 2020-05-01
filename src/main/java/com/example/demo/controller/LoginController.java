package com.example.demo.controller;

import com.example.demo.vo.LoginVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/1 23:59
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("do_login")
    public String do_login(LoginVo loginVo){
        System.out.println(loginVo);
        return "index";
    }
}
