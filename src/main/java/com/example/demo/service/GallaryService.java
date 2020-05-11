package com.example.demo.service;

import com.example.demo.dao.GalleryMapper;
import com.example.demo.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/11
 * description:
 */
@Service
public class GallaryService {
    @Autowired
    private GalleryMapper galleryMapper;
    public List<Announcement> getAnnouncementList(){
        return galleryMapper.selectAnnouncementList();
    }
}
