package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 10:19
 */
@Data
public class DownloadFile {
    private long fileId;
    private String fileName;
    private String fileType;
    private String fileLink;
    private Date fileReleaseDate;
}


