package com.example.demo.dao;

import com.example.demo.entity.Leader;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 12:20
 */
public interface LeaderMapper {
    List<Leader> selectLeaderList();
}
