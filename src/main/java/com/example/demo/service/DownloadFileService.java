package com.example.demo.service;

import com.example.demo.dao.DownloadMapper;
import com.example.demo.entity.DownloadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 10:27
 */
@Service
public class DownloadFileService {
    @Autowired
    private DownloadMapper downloadMapper;
    public List<DownloadFile> getDownloadFileListByType(String type){
        return downloadMapper.selectFileListByType(type);
    }
}
