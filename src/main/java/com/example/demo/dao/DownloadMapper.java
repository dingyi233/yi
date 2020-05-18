package com.example.demo.dao;

import com.example.demo.entity.DownloadFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 10:18
 */
public interface DownloadMapper {
    List<DownloadFile> selectFileListByType(@Param("fileType") String type);
}
