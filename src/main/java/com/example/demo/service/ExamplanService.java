package com.example.demo.service;

import com.example.demo.dao.ExamplanMapper;
import com.example.demo.vo.ExamPlanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/20 14:14
 */
@Service
public class ExamplanService {
    @Autowired
    private ExamplanMapper examplanMapper;
    public List<ExamPlanVo> getExamPlanList(long id){
        return examplanMapper.selectExamList(id);
    }

}
