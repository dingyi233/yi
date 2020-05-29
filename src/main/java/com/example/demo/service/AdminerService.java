package com.example.demo.service;

import com.example.demo.dao.AdminerMapper;
import com.example.demo.dao.ResourceMapper;
import com.example.demo.entity.Announcement;
import com.example.demo.entity.Resource;
import com.example.demo.vo.Result;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/24
 * description:
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class AdminerService {
    @Autowired
    ResourceMapper resourceMapper;

    public void uploadFile(InputStream inputStream, String name, String fileType, long userId) throws IOException {
        // 新建数据库数据
        Resource resource = new Resource();
        resource.setFileName(name);
        resource.setManagerAccount(userId);
        resource.setFileType(fileType);
        resource.setFileReleaseDate(new Date());
        int insert = resourceMapper.insert(resource);
        if (insert != 1) {
            throw new RuntimeException("cuole");
        }
        File file = new File("./res/"+resource.getFileId());
        if(file.exists()) {
            file.delete();
        }
        OutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(inputStream,outputStream);
        inputStream.close();
        outputStream.close();
    }
}
