package com.example.demo.controller;

import com.example.demo.common.PageUtils;
import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
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
 * @date 2020/5/20 22:51
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    @GetMapping("/news")
    public String gallery(HttpServletRequest request,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsList = newsService.getNewsList();
        PageInfo<News> pageInfo = new PageInfo<>(newsList);
        PageUtils.setPageInfo(request,pageInfo);
        request.setAttribute("newsList",newsList);
        return "news";
    }
}
