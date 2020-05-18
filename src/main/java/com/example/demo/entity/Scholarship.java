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
    private long scholarshipId;
    private String scholarshipType;
    private String scholarshipTitle;
    private String scholarshipContent;
    private String scholarshipReleaseDate;
}
