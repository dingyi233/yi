package com.example.demo.service;

import com.example.demo.entity.Scholarship;
import com.example.demo.dao.ScholarshipMapper;
import com.example.demo.vo.SalaryVo;
import com.example.demo.vo.ScholarshipDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.TrustAnchor;
import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/18
 * description:
 */
@Service
public class ScholarshipService {
    @Autowired
    public ScholarshipMapper scholarshipMapper;
    public List<Scholarship> getScholarshipListByType(String type,long userId){
        return scholarshipMapper.selectFileListByType(type,userId);
    }
    public List<ScholarshipDetailVo> getScholarshipList(long id){
        return scholarshipMapper.selectScholarshipList(id);
    }
}
