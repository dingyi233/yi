package com.example.demo.entity;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 11:06
 */
@Data
public class AcademicReport {
    private long academicdtId;
    private String academicdtProfessor;
    private String academicdtTitle;
    private Date academicdtTime;
    private Time reportDateStart;
    private Time reportDateEnd;
    private String reportAddr;
    private String reportDes;
    private Date reportDate;
}
