package com.example.demo.service;

import com.example.demo.dao.AcademicReportMapper;
import com.example.demo.entity.AcademicReport;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 11:14
 */
@Service
public class AcademicReportService {
    @Autowired
    private AcademicReportMapper acdemicReportMapper;
    public List<AcademicReport> getAcademicReportList(int pageSize){
        PageHelper.startPage(1,pageSize);
        return acdemicReportMapper.selectAcademicReportList();
    }
}
