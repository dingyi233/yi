package com.example.demo.dao;


import com.example.demo.entity.Contact;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 13:49
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface ContactMapper extends Mapper<Contact> {
    List<Contact> selectContactList();
    int insertContact(Contact contact);
}
