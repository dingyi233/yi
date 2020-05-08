package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: yi
 * @date: 2020/5/9
 * description:
 */
@Controller
public class contactController {
    @GetMapping("/contact")
    public  String contact(){ return "contact"; }
}
