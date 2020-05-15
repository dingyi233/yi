package com.example.demo.controller;

import com.example.demo.common.Constants;
import com.example.demo.entity.Announcement;
import com.example.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**首页控制器
 * @author yi
 * @date 2020/5/2 12:12
 */
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        List<Announcement> announcementList = indexService.getAnnouncementList();
        request.setAttribute("announcementList",announcementList);
        return "index";
    }

}
