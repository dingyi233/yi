package com.example.demo.controller;

import com.example.demo.dao.ContactMapper;
import com.example.demo.entity.Contact;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yi
 * @date: 2020/5/9
 * description:
 */
@Controller
public class ContactController {
    @Autowired
    private ContactMapper contactMapper;
    @GetMapping("/contact")
    public String contact(){ return "contact"; }
    @PostMapping("/contact/submit")
    @ResponseBody
    public Result submit(Contact contact){
        //后台验证数据
        //插入
        int result = contactMapper.insertContact(contact);
        if (result==1){
            return ResultGenerator.genSuccessResult("插入成功");
        }
        return ResultGenerator.genFailResult("插入失败");
    }
}
