package com.example.demo.dao;


import com.example.demo.entity.XsArrangement;
import com.example.demo.entity.ZsArrangement;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface XsArrangementMapper extends Mapper<XsArrangement> {
}
