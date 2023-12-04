package com.example.webproject.db;

import java.sql.*;

public class DBConnection {
    static final String url = "jdbc:mysql://localhost:3306/user";
    static final String username = "root";
    static final String password = "root";
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
