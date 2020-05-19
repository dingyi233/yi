package com.example.demo.dao;

/**
 * @author yi
 * @date 2020/5/2 12:15
 */
public interface SalaryMapper {
    double getSumSalary(long id,String currentDate, String monthDate);
    //查询两个时间戳中间的酬金

}
