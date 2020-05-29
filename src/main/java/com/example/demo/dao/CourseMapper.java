package com.example.demo.dao;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 15:13
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface CourseMapper extends Mapper<Course> {
    List<Course> selectCourseList();
}
