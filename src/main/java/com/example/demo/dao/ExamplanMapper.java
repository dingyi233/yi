package com.example.demo.dao;

import com.example.demo.vo.ExamPlanVo;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/20 14:15
 */
public interface ExamplanMapper {
    List<ExamPlanVo> selectExamList(long id);
}
