package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	protected ResultSet rs;
	protected Connection conn;

	// 获取链接
	public boolean getConnection() {
		return true;
	}

	// 通过连接池的方式获取连接
	public boolean getConnection2() {
		try {
			// 初始化上下文
			Context cxt = new InitialContext();
			// 获取与逻辑名相关联的数据源对象
			DataSource ds = (DataSource) cxt.lookup("java:comp/env/jdbc/news");
			conn = ds.getConnection();
			return true;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
