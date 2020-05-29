package com.example.demo.dao;

import com.example.demo.entity.AcademicReport;
import com.example.demo.entity.News;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 11:06
 */
public interface AcademicReportMapper {
    List<AcademicReport> selectAcademicReportList();
    Integer insertAcademic(AcademicReport academicReport);
}
