package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yi
 * @date 2020/5/2 12:09
 */
@Data
public class Announcement {
    private long announcementId;
    private long managerAccount;
    private String announcementType;
    private String announcementTitle;
    private String announcementContent;
    private Date announcementReleaseDate;
}
