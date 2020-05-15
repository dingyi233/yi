package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: yi
 * @date: 2020/5/15
 * description:
 */
@Controller
public class AdminerController {
    @GetMapping ("/adminer")
    public String adminer() {return "adminer"; }
}
