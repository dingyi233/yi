package com.example.demo.common;

import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;

/**分页工具类
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/21 0:00
 */
public class PageUtils {
    public static void setPageInfo(HttpServletRequest request, PageInfo pageInfo){
        //获得当前页
        request.setAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        request.setAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        request.setAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        request.setAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        request.setAttribute("isLastPage", pageInfo.isIsLastPage());
        //所有导航页号
        request.setAttribute("naviPageNums", pageInfo.getNavigatepageNums());
    }
}
