package com.example.demo.service;

import com.example.demo.dao.LeaderMapper;
import com.example.demo.entity.Leader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 12:26
 */
@Service
public class LeaderService {
    @Autowired
    private LeaderMapper leaderMapper;
    public List<Leader> getLeaderList(){
        return leaderMapper.selectLeaderList();
    }
}
