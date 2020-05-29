package com.example.demo.entity;


import lombok.Data;

/**
 * @author: yi
 * @date: 2020/5/24
 * description:
 */
@Data
public class Manager {
    private long managerAccount;
    private String managerName;
    private String managerPassword;
    private String managerDepartment;
    private String collegeId;
}
