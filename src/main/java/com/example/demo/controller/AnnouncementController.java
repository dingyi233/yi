package com.example.demo.controller;

import com.example.demo.common.PageUtils;
import com.example.demo.entity.Announcement;
import com.example.demo.service.AnnouncementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**公告页控制器
 * @author: yi
 * @date: 2020/5/8
 * description:
 */

@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @GetMapping ("/announcement")
    public String gallery(HttpServletRequest request,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Announcement> announcementList = announcementService.getAnnouncementList();
        PageInfo<Announcement> pageInfo=new PageInfo<>(announcementList);
        PageUtils.setPageInfo(request,pageInfo);
        request.setAttribute("announcementList",announcementList);
        return "announcement";
    }

}
