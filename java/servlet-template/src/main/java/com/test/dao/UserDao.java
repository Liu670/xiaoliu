package com.test.dao;

import com.test.pojo.User;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.test.util.DbUtils;
// 处理增删改查操作
public class UserDao {

    public User getUserByUsername(String username) {
        String sql = "select *  from user where username = ?";
        List param = new ArrayList();
        param.add(username);
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbUtils.open();
            statement = DbUtils.preparedStatement(sql, param, connection);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public int add(User user){
        String sql = "insert into user (username,password,nickname) value(?,?,?,)";
        List param = new ArrayList();
        param.add(user.getUsername());
        param.add(user.getPassword());
        param.add(user.getNickname());
        return DbUtils.executeUpdate(sql,param);
    }
}
