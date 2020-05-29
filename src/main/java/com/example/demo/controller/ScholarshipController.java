package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.common.PageUtils;
import com.example.demo.entity.Scholarship;
import com.example.demo.service.ScholarshipService;
import com.example.demo.vo.LoginVo;
import com.example.demo.vo.Result;
import com.example.demo.vo.SalaryVo;
import com.example.demo.vo.ScholarshipDetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        LoginVo loginVo= (LoginVo) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
        List<Scholarship> scholarships = scholarshipService.getScholarshipListByType(type,loginVo.getUserId());
        PageInfo<Scholarship> pageInfo=new PageInfo<>(scholarships);
        PageUtils.setPageInfo(request,pageInfo);
        request.setAttribute("scholarships",scholarships);
        request.setAttribute("type",type);
        return "scholarship";
    }
    @GetMapping("/user/scholarship")
    @ResponseBody
    public Result getScholarshipList(HttpServletRequest request){
        LoginVo loginVo= (LoginVo) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
        List<ScholarshipDetailVo> scholarshipDetailVoList = scholarshipService.getScholarshipList(loginVo.getUserId());
        Result<List> result=new Result<>();
        result.setResultCode(200);
        result.setMessage("查询成功");
        return result;
    }
}
