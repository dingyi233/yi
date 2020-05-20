package com.example.demo.controller;


import com.example.demo.entity.AcademicReport;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.News;
import com.example.demo.service.AcademicReportService;
import com.example.demo.service.AnnouncementService;
import com.example.demo.service.NewsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**首页控制器
 * @author yi
 * @date 2020/5/2 12:12
 */
@Controller
public class IndexController {
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private AcademicReportService academicReportService;
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        //通知公告
        PageHelper.startPage(1, 5);
        List<Announcement> announcementList = announcementService.getAnnouncementList();
        //学院新闻
        PageHelper.startPage(1, 6);
        List<News> newsList = newsService.getNewsList();
        //学术讲座
        PageHelper.startPage(1, 4);
        List<AcademicReport> academicReportList = academicReportService.getAcademicReportList();
        request.setAttribute("announcementList",announcementList);
        request.setAttribute("newsList",newsList);
        request.setAttribute("academicReportList",academicReportList);
        return "index";
    }

}
