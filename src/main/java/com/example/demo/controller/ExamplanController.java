package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.service.ExamplanService;
import com.example.demo.vo.ExamPlanVo;
import com.example.demo.vo.LoginVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/11
 * description:
 */
@Controller
public class ExamplanController {
    @Autowired
    private ExamplanService examplanService;

    @GetMapping("/examplan")
    public String examplan(HttpServletRequest request,
                           @RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "5") Integer pageSize) {
        LoginVo loginVo= (LoginVo) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
        PageHelper.startPage(pageNum, pageSize);
        List<ExamPlanVo> examPlanList = examplanService.getExamPlanList(loginVo.getUserId());
        PageInfo<ExamPlanVo> pageInfo=new PageInfo<>(examPlanList);
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
        request.setAttribute("examPlanList",examPlanList);
        return "examplan";
    }
}
