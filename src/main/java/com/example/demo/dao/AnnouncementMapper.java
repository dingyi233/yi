package com.example.demo.dao;

import com.example.demo.entity.Announcement;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 12:15
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface AnnouncementMapper extends Mapper<Announcement> {
    List<Announcement> selectAnnouncementList();
    Integer insertAnnoucement(Announcement announcement);
}
