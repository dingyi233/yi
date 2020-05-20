package com.example.demo.dao;

import com.example.demo.vo.SalaryVo;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 12:15
 */
public interface SalaryMapper {
    Double getSumSalary(long id,String currentDate, String monthDate);
    //查询两个时间戳中间的酬金
    List<SalaryVo> selectSalaryList(long id, String startDate, String endDate);


}
