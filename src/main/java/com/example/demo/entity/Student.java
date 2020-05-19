package com.example.demo.entity;

import lombok.Data;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 15:07
 */
@Data
public class Student {
    private long studentId;
    private String studentName;
    private String studentPassword;
    private String researchDirection;
    private long teacherId;
    private String academy;
    private String studentType;
    private String politicalStatus;
    private long studentTel;
}


