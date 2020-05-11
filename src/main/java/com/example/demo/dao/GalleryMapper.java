package com.example.demo.dao;

import com.example.demo.entity.Announcement;

import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/11
 * description:
 */
public interface GalleryMapper {
    List<Announcement> selectAnnouncementList();
}
