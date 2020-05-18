package com.example.demo.service;
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
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public boolean checkLogin(LoginVo loginVo){
        String dbPassword =studentMapper.getPasswordByName(loginVo.getUserId());
        if (loginVo.getPassword().equals(dbPassword)){
            return true;
        }
        return false;
    }
    public int updatePassword(UpdatePasswordVo updatePasswordVo){
        return studentMapper.updatePassword(updatePasswordVo);

    }

}
