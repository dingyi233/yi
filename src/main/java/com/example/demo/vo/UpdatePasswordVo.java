package com.example.demo.vo;

import lombok.Data;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 11:36
 */
@Data
public class UpdatePasswordVo {
    private long studentId;
    private String oldPassword;
    private String newPassword;
    private String newPasswordReview;
}
