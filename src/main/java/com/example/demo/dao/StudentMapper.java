package com.example.demo.dao;

import com.example.demo.vo.UpdatePasswordVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author yi
 * @date 2020/5/2 8:54
 */
public interface StudentMapper {
    /**
     *  查找密码
     * @param name id
     * @return password
     */
    String getPasswordByName(@Param("name") long name);

    int updatePassword(@Param("updatePasswordVo") UpdatePasswordVo updatePasswordVo);
}
