package com.example.demo.controller;

import com.example.demo.common.PageUtils;
import com.example.demo.entity.Resource;
import com.example.demo.service.DownloadFileService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.FileOutputStream;
import java.io.IOException;
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
                           @RequestParam(defaultValue = "奖助贷") String type) {
        PageHelper.startPage(pageNum, pageSize);
        List<Resource> resources = downloadFileService.getDownloadFileListByType(type);
        PageInfo<Resource> pageInfo = new PageInfo<>(resources);
        PageUtils.setPageInfo(request, pageInfo);
        request.setAttribute("downloadFiles", resources);
        request.setAttribute("type", type);
        return "download";
    }

    @GetMapping("/downloadFile")
    public void downloadFile(@RequestParam String fileId, HttpServletResponse response) throws IOException {
        downloadFileService.downloadFile(Long.parseLong(fileId), response);
    }


}
