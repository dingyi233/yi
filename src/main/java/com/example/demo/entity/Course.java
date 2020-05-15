package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yi
 * @date 2020/5/2 15:14
 */
@Data
public class Course {
    private String courseId;
    private String courseName;
    private double credit;
    private Date startDate;
    private long teacherId;
    private long studentId;

}
