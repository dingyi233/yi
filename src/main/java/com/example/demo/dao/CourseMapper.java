package com.example.demo.dao;

import com.example.demo.entity.Course;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 15:13
 */
public interface CourseMapper {
    List<Course> selectCourseList();
}
