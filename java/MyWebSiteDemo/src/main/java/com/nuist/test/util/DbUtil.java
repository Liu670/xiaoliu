package com.nuist.test.util;
// DbUtil.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root";

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
}
