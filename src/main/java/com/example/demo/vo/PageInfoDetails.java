package com.example.demo.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/20 20:00
 */
@Data
public class PageInfoDetails<T> {
    private int pageNum;
    private int pageSize;
    private boolean isFirstPage;
    private int totalPages;
    private boolean isLastPage;
    private int[] naviPageNums;
    private List<T> dataList;
    public PageInfoDetails(List<T> data){
        this.dataList=data;
        PageInfo<T> pageInfo=new PageInfo<>(data);
        pageNum=pageInfo.getPageNum();
        pageSize=pageInfo.getPageSize();
        isFirstPage=pageInfo.isIsFirstPage();
        totalPages=pageInfo.getPages();
        isLastPage=pageInfo.isIsLastPage();
        naviPageNums=pageInfo.getNavigatepageNums();
    }
}
