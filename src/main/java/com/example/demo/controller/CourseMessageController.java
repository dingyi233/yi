package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: yi
 * @date: 2020/5/11
 * description:
 */
@Controller
public class CourseMessageController {
    @GetMapping("/coursemessage")
    public String coursemassage() {
        return "coursemessage";
    }
}
