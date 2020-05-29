package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.dao.*;
import com.example.demo.entity.AcademicReport;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.Contact;
import com.example.demo.entity.News;
import com.example.demo.service.AdminerService;
import com.example.demo.service.ContactService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.ResultGenerator;
//import com.sun.org.apache.bcel.internal.generic.NEW;
import com.example.demo.vo.SalaryVo;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private SalaryMapper salaryMapper;
    @Autowired
    private ContactService contactService;
    @GetMapping ("/adminer")
    public String adminer(HttpServletRequest httpServletRequest) {

        List<Contact> contactList = contactService.getContactList();
        httpServletRequest.setAttribute("contactList",contactList);
        return "adminer"; }
//
//    @GetMapping ("/adminer/contact")
//    public String contact(){
//        System.out.println(contactList);
//        return "adminer";
//    }
    @GetMapping()

    @PostMapping("/adminer/annoucementSubmit")
    @ResponseBody
    public Result announcementSubmit(Announcement announcement){
        //后台验证数据
        //插入
        announcement.setAnnouncementReleaseDate(new Date());
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

    @PostMapping("adminer/salarySubmit")
    @ResponseBody
    public Result salarySubmit(SalaryVo salaryVo){
        //后台验证数据
        //插入
        Integer result = salaryMapper.insertSalary(salaryVo);
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
