package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

// 数据库连接
public class DBConnection {

	static final String url = "jdbc:mysql://localhost:3306/user";
	static final String username = "root";
	static final String password = "root";

	public static Connection getConnection() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
//			stmt=Statemen
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}