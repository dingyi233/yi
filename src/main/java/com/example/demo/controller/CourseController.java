package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 15:11
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String courses(HttpServletRequest request) {
        List<Course> courseList = courseService.getCourseList();
        request.setAttribute("courseList",courseList);
        return "courses";
    }
}
