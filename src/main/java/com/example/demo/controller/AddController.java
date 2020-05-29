package com.example.demo.controller;

import com.example.demo.entity.BsArrangement;
import com.example.demo.entity.Course;
import com.example.demo.entity.XsArrangement;
import com.example.demo.entity.ZsArrangement;
import com.example.demo.service.add.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add")
public class AddController {
    final
    AddService addService;

    public AddController(AddService addService) {
        this.addService = addService;
    }

    @GetMapping("/getBsCourses")
    ResponseEntity<List<Course>> getBsCourses() {
        return addService.getBsCourses();
    }

    @GetMapping("/getXsCourses")
    ResponseEntity<List<Course>> getXsCourses() {
        return addService.getXsCourses();
    }

    @GetMapping("/getZsCourses")
    ResponseEntity<List<Course>> getZsCourses() {
        return addService.getZsCourses();
    }

    @PostMapping("/arrangementZsCourses")
    ResponseEntity<Void> arrangementZsCourses(@RequestBody List<ZsArrangement> zsArrangementList) {
        return addService.arrangementZsCourses(zsArrangementList);
    }

    @PostMapping("/arrangementXsCourses")
    ResponseEntity<Void> arrangementXsCourses(@RequestBody List<XsArrangement> xsArrangementList) {
        return addService.arrangementXsCourses(xsArrangementList);
    }

    @PostMapping("/arrangementBsCourses")
    ResponseEntity<Void> arrangementBsCourses(@RequestBody List<BsArrangement> bsArrangementList) {
        return addService.arrangementBsCourses(bsArrangementList);
    }
}
