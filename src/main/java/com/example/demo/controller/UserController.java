package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.service.UserService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
import com.example.demo.vo.UpdatePasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author yi
 * @date 2020/5/1 23:59
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

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
        boolean checkLogin = userService.checkLogin(loginVo);
        if (checkLogin){
            //设置session
            httpSession.setAttribute(Constants.USER_SESSION_KEY,loginVo);
            return ResultGenerator.genSuccessResult(loginVo.getLoginType());
        }else {
            return ResultGenerator.genFailResult("账号密码有误");
        }
    }
    @GetMapping("/logout")
    public String userLogout(HttpSession httpSession){
        //清除session
        httpSession.removeAttribute(Constants.USER_SESSION_KEY);
        //返回登陆页面
        return "login";
    }
    @PostMapping("/updatePassword")
    @ResponseBody
    public Result updatePassword(UpdatePasswordVo updatePasswordVo){
        //验证两次新密码是否一致
        if (updatePasswordVo.getNewPassword()==updatePasswordVo.getNewPasswordReview()){
            int result = userService.updatePassword(updatePasswordVo);
            if (result==1){
                return ResultGenerator.genSuccessResult("密码更新成功");
            }else{
                return ResultGenerator.genFailResult("旧密码不正确");
            }
        }else{
            return ResultGenerator.genFailResult("两次密码不一致");
        }
    }
}
