package com.example.demo.dao;

import com.example.demo.entity.Announcement;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 12:15
 */
public interface IndexMapper {
    List<Announcement> selectAnnouncementList();
}
