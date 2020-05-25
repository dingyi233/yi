package com.example.demo.controller;

import com.example.demo.dao.AcademicReportMapper;
import com.example.demo.dao.AdminerMapper;
import com.example.demo.dao.AnnouncementMapper;
import com.example.demo.dao.NewsMapper;
import com.example.demo.entity.AcademicReport;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.News;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yi
 * @date: 2020/5/15
 * description:
 */
@Controller
public class AdminerController {
    @Autowired
//    private AdminerMapper adminerMapper;

    private AnnouncementMapper announcementMapper;
    @GetMapping ("/adminer")
    public String adminer() {return "adminer"; }
    @PostMapping("/adminer/annoucementSubmit")
    @ResponseBody
    public Result announcementSubmit(Announcement announcement){
        //后台验证数据
        //插入
        Integer result = announcementMapper.insertAnnoucement(announcement);
        if (result==1){
            return ResultGenerator.genSuccessResult("插入成功");
        }
        return ResultGenerator.genFailResult("插入失败");
    }
    @Autowired
    private NewsMapper newsMapper;
    @PostMapping("/adminer/newsSubmit")
    @ResponseBody
    public Result newsSubmit(News news){
        //后台验证数据
        //插入
        Integer result = newsMapper.insertNews(news);
        if (result==1){
            return ResultGenerator.genSuccessResult("插入成功");
        }
        return ResultGenerator.genFailResult("插入失败");
    }
    @Autowired
    private AcademicReportMapper academicReportMapper;
    @PostMapping("adminer/academicSubmit")
    @ResponseBody
    public Result academicSubmit(AcademicReport academicReport){
        //后台验证数据
        //插入
        Integer result = academicReportMapper.insertAcademic(academicReport);
        if (result==1){
            return ResultGenerator.genSuccessResult("插入成功");
        }
        return ResultGenerator.genFailResult("插入失败");
    }

}
