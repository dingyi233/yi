package com.example.demo.dao;


import com.example.demo.entity.BsArrangement;
import com.example.demo.entity.XsArrangement;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface BsArrangementMapper extends Mapper<BsArrangement> {
}
