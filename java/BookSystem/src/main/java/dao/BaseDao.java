package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.ConfigManager;

// 通用数据库操作类 （建立连接 释放资源 增删改）
public class BaseDao {
	protected Connection conn;// 连接
	protected Statement stmt;// 执行sql语句
	protected PreparedStatement pstmt;// 执行sql语句
	protected ResultSet rs;// 结果集

	// 获取连接
	public boolean getConnection() {
		String driver = ConfigManager.Instance().getValue("driver");
		String url = ConfigManager.Instance().getValue("url");
		String username = ConfigManager.Instance().getValue("username");
		String password = ConfigManager.Instance().getValue("password");
		try {
			// 加载驱动
			Class.forName(driver);
			// 获取连接对象
			conn = DriverManager.getConnection(url, username, password);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 释放资源
	public boolean closeResource() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (pstmt != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (stmt != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if (conn != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	// 增删改
	public int executeUpdate(String sql, Object[] params) {
		int updateRows = -1;
		// 判断是否获取到连接
		if (getConnection()) {
			try {
				pstmt = conn.prepareStatement(sql);
				// 循环填充占位符
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				updateRows = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateRows;
	}

	// 查询
	public ResultSet executeQuery(String sql, Object[] params) {
		// 判断是否获取到连接
		if (getConnection()) {
			try {
				pstmt = conn.prepareStatement(sql);
				// 循环填充占位符
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				rs = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
