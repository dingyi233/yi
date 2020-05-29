package com.example.demo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/17 13:42
 */
@Data
@Entity
public class Contact {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    private Long id;
    private Long studentId;
    private String name;
    private String email;
    private String phone;
    private String message;
}

