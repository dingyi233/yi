package com.example.demo.dao;

import com.example.demo.entity.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 10:18
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface ResourceMapper extends Mapper<Resource> {

}
