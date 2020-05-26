package com.example.demo.service;

import com.example.demo.dao.ResourceMapper;
import com.example.demo.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 10:27
 */
@Service
public class DownloadFileService {
    @Autowired
    private ResourceMapper resourceMapper;

    public List<Resource> getDownloadFileListByType(String type) {
        Resource resource = new Resource();
        resource.setFileType(type);
        return resourceMapper.select(resource);
    }

    public void downloadFile(long fileId, HttpServletResponse response) throws IOException {
        File file = new File("./res/" + fileId);
        Resource resource = new Resource();
        resource.setFileId(fileId);
        resource = resourceMapper.selectByPrimaryKey(resource);
        response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + resource.getFileName() + ";filename*=utf-8''"
                + URLEncoder.encode(resource.getFileName(), "UTF-8"));
        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
    }
}
