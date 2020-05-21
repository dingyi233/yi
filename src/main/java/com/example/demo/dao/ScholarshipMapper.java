package com.example.demo.dao;

import com.example.demo.entity.Scholarship;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yi
 * @date: 2020/5/18
 * description:
 */
public interface ScholarshipMapper {
    List<Scholarship> selectFileListByType(@Param("fileType") String type,long userId);
}
