package com.example.demo.dao;

import com.example.demo.entity.News;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 9:49
 */
public interface NewsMapper {
    List<News> selectNewsList();
}
