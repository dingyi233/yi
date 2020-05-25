package com.example.demo.dao;

import com.example.demo.entity.Announcement;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 12:15
 */
public interface AnnouncementMapper {
    List<Announcement> selectAnnouncementList();
    Integer insertAnnoucement(Announcement announcement);
}
