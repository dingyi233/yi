package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author: yi
 * @date: 2020/5/24
 * description:
 */
public class ScholarshipDetailVo {
    private long scholarshipStuId;
    //平均成绩
    private double averGrade;
    //学术成就数
    private int academicAchievement;
    //社会实践次数
    private int socialPractice;
    //总分
    private double totalScore;
}
