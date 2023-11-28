package com.example.springbootdemo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能：用户实体类
 * 作者：程序员DrLong
 * 日期：2023/11/27 03:27
 */
@Data//Git和Set和toString方法
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
//@TableName("User")
public class User {
    private Integer id;
    private String pwd;
}