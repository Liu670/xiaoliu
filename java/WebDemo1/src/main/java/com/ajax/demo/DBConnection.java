package com.ajax.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/car?useUnicode=true&characterEncoding=utf-8";
	String user = "root";
	String password = "root";

	public Connection conn;

	public DBConnection() {

		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);// 杩炵画鏁版嵁搴�

			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}