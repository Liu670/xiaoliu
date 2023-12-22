package com.nuist.test.util;
// DbUtil.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static final ConfigManager manger = new ConfigManager();

	static {
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName(manger.getValue("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user";
//	private static final String JDBC_USER = "root";
//	private static final String JDBC_PASSWORD = "root";
	private static final String JDBC_URL = manger.getValue("url");
	private static final String JDBC_USER = manger.getValue("username");
	private static final String JDBC_PASSWORD = manger.getValue("password");

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
}
