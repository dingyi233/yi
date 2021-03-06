package com.example.demo.service;

import com.example.demo.dao.ContactMapper;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 13:56
 */
@Service
public class ContactService {
    @Autowired
    private ContactMapper contactMapper;
    public List<Contact> getContactList(){
        return contactMapper.selectContactList();
    }
    public int insertContact(Contact contact){
        return contactMapper.insertContact(contact);
    }
}
