package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Database driver not found", e);
		}
	}
}
