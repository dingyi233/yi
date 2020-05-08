package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: yi
 * @date: 2020/5/8
 * description:
 */

@Controller
public class GalleryController {

    @GetMapping ("/gallery")
    public String gallery() { return "gallery"; }

}
