package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/2 12:09
 */
@Data
public class Announcement {
    private long announcementId;
    private String announcementType;
    private String announcementTitle;
    private String announcementContent;
    private Date announcementReleaseDate;
}
