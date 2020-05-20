package com.example.demo.controller;

import com.example.demo.entity.Scholarship;
import com.example.demo.service.ScholarshipService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/8
 * description:
 */
@Controller
public class ScholarshipController {
    @Autowired
    private ScholarshipService scholarshipService;
    @GetMapping("/scholarship")
    public String scholarship(HttpServletRequest request,
                           HttpServletResponse response,
                           @RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "5") Integer pageSize,
                           @RequestParam(defaultValue = "奖学金")String type){
        PageHelper.startPage(pageNum, pageSize);
        List<Scholarship> scholarships = scholarshipService.getScholarshipListByType(type);
        PageInfo<Scholarship> pageInfo=new PageInfo<>(scholarships);
        //获得当前页
        request.setAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        request.setAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        request.setAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        request.setAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        request.setAttribute("isLastPage", pageInfo.isIsLastPage());
        //所有导航页号
        request.setAttribute("naviPageNums", pageInfo.getNavigatepageNums());
        request.setAttribute("scholarships",scholarships);
        request.setAttribute("type",type);
        return "scholarship";
    }
}
