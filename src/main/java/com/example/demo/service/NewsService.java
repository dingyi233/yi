package com.example.demo.service;

import com.example.demo.dao.NewsMapper;
import com.example.demo.entity.News;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 9:50
 */
@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public List<News> getNewsList(){
        return newsMapper.selectNewsList();
    }
}
