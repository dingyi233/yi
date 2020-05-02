package com.example.demo.service;

import com.example.demo.dao.IndexMapper;
import com.example.demo.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 12:21
 */
@Service
public class IndexService {
    @Autowired
    private IndexMapper indexMapper;
    public List<Announcement> getAnnouncementList(){
        return indexMapper.selectAnnouncementList();
    }
}