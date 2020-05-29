package com.example.demo.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: yi
 * @date: 2020/5/28
 * description:
 */
@Data
@Entity
public class ZsArrangement {
    @Id
    @KeySql(useGeneratedKeys = true, dialect = IdentityDialect.MYSQL)
    private  Long id;
    private Long year;
    private String semester;
    private Long week;
    private Long dayOfWeek;
    private String c1Id;
    private String c2Id;
    private String c3Id;
    private String c4Id;
    private String c5Id;
    private String c6Id;
}
