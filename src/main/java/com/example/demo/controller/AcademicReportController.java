package com.example.demo.controller;

import com.example.demo.common.PageUtils;
import com.example.demo.entity.AcademicReport;
import com.example.demo.entity.News;
import com.example.demo.service.AcademicReportService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 11:17
 */
@Controller
public class AcademicReportController {
    @Autowired
    private AcademicReportService academicReportService;

    @GetMapping("/academicReport")
    public String gallery(HttpServletRequest request,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "4") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<AcademicReport> academicReportList = academicReportService.getAcademicReportList();
        PageInfo<AcademicReport> pageInfo = new PageInfo<>(academicReportList);
        //设置分页属性
        PageUtils.setPageInfo(request,pageInfo);
        request.setAttribute("academicReportList",academicReportList);
        return "academic";
    }
}
