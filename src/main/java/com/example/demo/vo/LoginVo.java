package com.example.demo.vo;

import lombok.Data;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 0:13
 */
@Data
public class LoginVo {
    private String userName;
    private String password;
    private String loginType;
    private boolean rememberMe;
}
