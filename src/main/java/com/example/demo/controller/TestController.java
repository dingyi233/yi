package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: yi
 * @date: 2020/5/25
 * description:
 */
@Controller
public class TestController {
    @GetMapping("/test")
    public String test(){
        return  "test";
    }
}
