package com.example.demo.service;

import com.example.demo.dao.AnnouncementMapper;
import com.example.demo.entity.Announcement;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 12:21
 */
@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;
    public List<Announcement> getAnnouncementList(int pageSize){
        PageHelper.startPage(1,pageSize);
        return announcementMapper.selectAnnouncementList();
    }
}
