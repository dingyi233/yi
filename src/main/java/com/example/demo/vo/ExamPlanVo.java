package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

/**
 * 考试安排
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/20 14:07
 */
@Data
public class ExamPlanVo {
    private long studentId;
    private String studentName;
    private String courseName;
    private String teacherName;
    private String classroomAddr;
    private Date examDate;
}
