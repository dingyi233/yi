package com.example.demo.service.add;

import com.example.demo.dao.BsArrangementMapper;
import com.example.demo.dao.CourseMapper;
import com.example.demo.dao.XsArrangementMapper;
import com.example.demo.dao.ZsArrangementMapper;
import com.example.demo.entity.BsArrangement;
import com.example.demo.entity.Course;
import com.example.demo.entity.XsArrangement;
import com.example.demo.entity.ZsArrangement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddService {
    final
    CourseMapper courseMapper;
    final
    ZsArrangementMapper zsArrangementMapper;
    final
    BsArrangementMapper bsArrangementMapper;
    final
    XsArrangementMapper xsArrangementMapper;

    public AddService(CourseMapper courseMapper, ZsArrangementMapper zsArrangementMapper, BsArrangementMapper bsArrangementMapper, XsArrangementMapper xsArrangementMapper) {
        this.courseMapper = courseMapper;
        this.zsArrangementMapper = zsArrangementMapper;
        this.bsArrangementMapper = bsArrangementMapper;
        this.xsArrangementMapper = xsArrangementMapper;
    }

    public ResponseEntity<List<Course>> getBsCourses() {
        Course course = new Course();
        course.setCourseAdapt("博士");
        List<Course> select = courseMapper.select(course);
        return ResponseEntity.ok(select);
    }

    public ResponseEntity<List<Course>> getXsCourses() {
        Course course = new Course();
        course.setCourseAdapt("学硕");
        List<Course> select = courseMapper.select(course);
        return ResponseEntity.ok(select);
    }

    public ResponseEntity<List<Course>> getZsCourses() {
        Course course = new Course();
        course.setCourseAdapt("专硕");
        List<Course> select = courseMapper.select(course);
        return ResponseEntity.ok(select);
    }

    public ResponseEntity<Void> arrangementZsCourses(List<ZsArrangement> zsArrangementList) {
        for (ZsArrangement zsArrangement : zsArrangementList) {
            zsArrangementMapper.insert(zsArrangement);
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> arrangementBsCourses(List<BsArrangement> bsArrangementList) {
        for (BsArrangement bsArrangement : bsArrangementList) {
            bsArrangementMapper.insert(bsArrangement);
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> arrangementXsCourses(List<XsArrangement> xsArrangementList) {
        for (XsArrangement xsArrangement : xsArrangementList) {
            xsArrangementMapper.insert(xsArrangement);
        }
        return ResponseEntity.ok().build();
    }
}
