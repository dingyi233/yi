package com.example.demo.controller;

import com.example.demo.entity.Leader;
import com.example.demo.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**学院概况
 * @author yi
 * @date 2020/5/2 13:39
 */
@Controller
public class AboutController {
    @Autowired
    private LeaderService leaderService;
    @GetMapping("/about")
    public String about(HttpServletRequest request){
        List<Leader> leaderList = leaderService.getLeaderList();
        request.setAttribute("leaderList",leaderList);
        return "about";
    }

}
