package com.example.demo.service;

import com.example.demo.dao.LoginMapper;
import com.example.demo.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 8:52
 */
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public boolean checkLogin(LoginVo loginVo){
        String dbPassword =loginMapper.getPasswordByName(loginVo.getUserName());
        if (loginVo.getPassword().equals(dbPassword)){
            return true;
        }
        return false;
    }

}
