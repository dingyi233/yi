package com.example.demo.service;

import com.example.demo.dao.CourseMapper;
import com.example.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 15:20
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    public List<Course> getCourseList(){
        return courseMapper.selectCourseList();
    }
}
