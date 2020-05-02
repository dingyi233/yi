package com.example.demo.dao;

import com.example.demo.entity.Course;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 15:13
 */
public interface CourseMapper {
    List<Course> selectCourseList();
}
