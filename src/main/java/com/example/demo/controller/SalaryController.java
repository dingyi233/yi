package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.service.SalaryService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
import com.example.demo.vo.SalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public String salary(HttpServletRequest request) {
        LoginVo loginVo= (LoginVo) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
        double currentMonthSalary = salaryService.getCurrentMonthSalary(loginVo.getUserId());
        request.setAttribute("currentMonthSalary", currentMonthSalary);
        return "salary";
    }
    @GetMapping("/user/salary")
    @ResponseBody
    public Result getSalary(HttpServletRequest request,@RequestParam("selectStartDate")String startDate,
                            @RequestParam("selectEndDate")String endDate){
        LoginVo loginVo= (LoginVo) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
        List<SalaryVo> salaryList = salaryService.getSalaryList(loginVo.getUserId(),startDate,endDate);
        Result<List> result=new Result<>();
        result.setData(salaryList);
        result.setResultCode(200);
        result.setMessage("查询成功");
        return result;
    }
}

