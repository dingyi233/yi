package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.dao.AcademicReportMapper;
import com.example.demo.dao.AdminerMapper;
import com.example.demo.dao.AnnouncementMapper;
import com.example.demo.dao.NewsMapper;
import com.example.demo.entity.AcademicReport;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.News;
import com.example.demo.service.AdminerService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yi
 * @date: 2020/5/15
 * description:
 */
@Controller
public class AdminerController {
//    private AdminerMapper adminerMapper;

    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private AcademicReportMapper academicReportMapper;
    @Autowired
    AdminerService adminerService;

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

    @PostMapping("adminer/uploadFile/{fileType}")
    @ResponseBody
    Result uploadFile(@RequestParam MultipartFile file,@PathVariable String fileType, HttpSession httpSession) throws IOException {
        LoginVo loginVo = (LoginVo) httpSession.getAttribute(Constants.USER_SESSION_KEY);
        if (!file.isEmpty()) {
            InputStream inputStream = file.getInputStream();
            // store the bytes somewhere
            adminerService.uploadFile(inputStream, file.getOriginalFilename(),fileType,loginVo.getUserId());
            return ResultGenerator.genSuccessResult("上传成功");
        } else {
            return ResultGenerator.genFailResult("上传失败");
        }
    }
}
