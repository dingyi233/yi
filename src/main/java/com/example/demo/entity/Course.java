package com.example.demo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yi
 * @date 2020/5/2 15:14
 */
@Data
@Entity
public class Course {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    private String courseId;
    private String courseType;
    private String courseName;
    private Long courseTimes;
    private Double credit;
    private String examType;
    private String courseRequirements;
    private String semester;
    private Long courseCapacity;
    private String courseAdapt;
    private Long teacherId;
}
