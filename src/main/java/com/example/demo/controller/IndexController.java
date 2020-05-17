package com.example.demo.controller;


import com.example.demo.entity.Announcement;
import com.example.demo.entity.News;
import com.example.demo.service.AnnouncementService;
import com.example.demo.service.NewsService;
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
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        //通知公告
        List<Announcement> announcementList = announcementService.getAnnouncementList();
        //学院新闻
        List<News> newsList = newsService.getNewsList();
        //学术讲座
        request.setAttribute("announcementList",announcementList);
        request.setAttribute("newsList",newsList);
        return "index";
    }

}
