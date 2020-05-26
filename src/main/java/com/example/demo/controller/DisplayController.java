package com.example.demo.controller;

import com.example.demo.dao.AnnouncementMapper;
import com.example.demo.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yi
 * @date: 2020/5/27
 * description:
 */
@Controller
public class DisplayController {
    @Autowired
    AnnouncementMapper announcementMapper;
    @GetMapping("/display")
    public String display(HttpServletRequest request, @RequestParam String announcementId) {
        Announcement announcement = new Announcement();
        announcement.setAnnouncementId(Long.parseLong(announcementId));
        request.setAttribute("announcement",announcementMapper.selectByPrimaryKey(announcement));
        return "display";
    }
}
