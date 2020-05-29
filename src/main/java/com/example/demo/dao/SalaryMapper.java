package com.example.demo.dao;

import com.example.demo.entity.Announcement;
import com.example.demo.vo.SalaryVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yi
 * @date 2020/5/2 12:15
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface SalaryMapper extends Mapper<SalaryVo> {
    Double getSumSalary(long id, String currentDate, String monthDate);
    //查询两个时间戳中间的酬金
    List<SalaryVo> selectSalaryList(long id, String startDate, String endDate);
    Integer insertSalary(SalaryVo salaryVo);

}
