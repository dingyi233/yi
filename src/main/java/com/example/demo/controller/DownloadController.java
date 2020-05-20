package com.example.demo.controller;

import com.example.demo.common.PageUtils;
import com.example.demo.entity.DownloadFile;
import com.example.demo.service.DownloadFileService;
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
public class DownloadController {
    @Autowired
    private DownloadFileService downloadFileService;
    @GetMapping("/download")
    public String download(HttpServletRequest request,
                           HttpServletResponse response,
                           @RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "5") Integer pageSize,
                           @RequestParam(defaultValue = "奖助贷下载")String type){
        PageHelper.startPage(pageNum, pageSize);
        List<DownloadFile> downloadFiles = downloadFileService.getDownloadFileListByType(type);
        PageInfo<DownloadFile> pageInfo=new PageInfo<>(downloadFiles);
        PageUtils.setPageInfo(request,pageInfo);
        request.setAttribute("downloadFiles",downloadFiles);
        request.setAttribute("type",type);
        return "download";
    }


}
