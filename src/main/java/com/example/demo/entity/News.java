package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 9:44
 */
@Data
public class News {
    private long newsId;
    private String newsTitle;
    private String newsContent;
    private Date newsDate;
    private String newsImg;
    private String newsCreater;
}
