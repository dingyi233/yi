package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.crypto.interfaces.PBEKey;

/**
 * @author: yi
 * @date: 2020/5/9
 * description:
 */
@Controller
public class MymessageController {
    @GetMapping ("/mymessage")
    public String mymassage() { return "mymessage"; }
}
