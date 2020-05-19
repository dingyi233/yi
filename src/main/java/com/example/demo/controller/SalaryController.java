package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.service.SalaryService;
import com.example.demo.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: yi
 * @date: 2020/5/8
 * description:
 */
@Controller
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/salary")
    public String salary(HttpServletRequest request, HttpSession session) {
        LoginVo loginVo= (LoginVo) session.getAttribute(Constants.USER_SESSION_KEY);
        double currentMonthSalary = salaryService.getCurrentMonthSalary(loginVo.getUserId());
        request.setAttribute("currentMonthSalary", currentMonthSalary);
        return "salary";

    }
}

