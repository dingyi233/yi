package com.example.demo.service;

import com.example.demo.dao.SalaryMapper;
import com.example.demo.vo.SalaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 15:17
 */
@Service
public class SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    public double getCurrentMonthSalary(long studentId) {
        //当前时间
        Date currentDate = new Date();
        //该月的开始时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date monthDate = new Date(getMonthFirstDay());
        String currentFormat = formatter.format(currentDate);
        String monthFormat = formatter.format(monthDate);
        Double sumSalary = salaryMapper.getSumSalary(studentId, currentFormat, monthFormat);
        if (sumSalary==null){
            return 0;
        }
        return sumSalary;
    }

    public long getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis();
    }

    public List<SalaryVo> getSalaryList(long id,String startDate,String endDate){
        return salaryMapper.selectSalaryList(id,startDate,endDate);
    }

    public Integer insertSalary(SalaryVo salaryVo){
        return salaryMapper.insertSalary(salaryVo);
    }
 }
