package com.example.demo.controller;

import com.example.demo.entity.Announcement;
import com.example.demo.service.GallaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**公告页控制器
 * @author: yi
 * @date: 2020/5/8
 * description:
 */

@Controller
public class GalleryController {
    @Autowired
    private GallaryService galleryService;
    @GetMapping ("/gallery")
    public String gallery(HttpServletRequest request){
        List<Announcement> announcementList = galleryService.getAnnouncementList();
        request.setAttribute("announcementList",announcementList);
        return "gallery";
    }

}
