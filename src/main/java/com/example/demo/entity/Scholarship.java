package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: yi
 * @date: 2020/5/18
 * description:
 */
@Data
public class Scholarship{
    private Long scholarshipId;
    private String scholarshipFile;
    private String scholarshipType;
    private String scholarshipLevel;
    private Long announcementId;
    private Date scholarshipReleaseDate;
    private String scholarshipTitle;
    private String scholarshipContent;
    private String scholoarshipFilename;

}
