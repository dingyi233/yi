package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**学院概况
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 13:39
 */
@Controller
public class AboutController {
    @GetMapping("/about")
    public String about(){
        return "about";
    }

}