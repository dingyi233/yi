package com.example.demo.entity;

import lombok.Data;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 13:42
 */
@Data
public class Contact {
    private long id;
    private long studentId;
    private String name;
    private String email;
    private String phone;
    private String message;
}

