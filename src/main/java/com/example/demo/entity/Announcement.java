package com.example.demo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yi
 * @date 2020/5/2 12:09
 */
@Data
@Entity
public class Announcement {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    private Long announcementId;
    private String announcementTitle;
    private String announcementContent;
    private Date announcementReleaseDate;
    private String announcementImg;
    private Long managerAccount;
}
