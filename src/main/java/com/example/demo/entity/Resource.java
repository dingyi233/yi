package com.example.demo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 曾伟 zengwei233@126.com
 * @date 2020/5/18 10:19
 */
@Data
@Entity
public class Resource {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    private Long fileId;
    private String fileName;
    private String fileType;
    private Long managerAccount;
    private Date fileReleaseDate;
}


