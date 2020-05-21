package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/20 15:52
 */
@Data
public class SalaryVo {
    private String salaryDes;
    private String salaryAccount;
    private String salaryType;
    //总额
    private double salaryTotal;
    //扣税
    private double salaryDeduction;
    //实发
    private double salaryAmount;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date salaryDate;
    private String salaryManager;
    private String salaryDepart;



}
