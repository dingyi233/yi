package com.example.demo.service;

import com.example.demo.dao.ManagerMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.UpdatePasswordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 8:52
 */
@Service
public class UserService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ManagerMapper managerMapper;

    public boolean checkLogin(LoginVo loginVo) {
        String dbPassword=null;
        //判断登陆类型
        if ("学生".equals(loginVo.getLoginType())) {
            dbPassword = studentMapper.getPasswordByName(loginVo.getUserId());
        } else if ("工作人员".equals(loginVo.getLoginType())) {
            dbPassword = managerMapper.getPasswordByName(loginVo.getUserId());
        }

        if (loginVo.getPassword().equals(dbPassword)) {
            return true;
        }
        return false;
    }

    public int updatePassword(UpdatePasswordVo updatePasswordVo) {
        return studentMapper.updatePassword(updatePasswordVo);

    }

}
