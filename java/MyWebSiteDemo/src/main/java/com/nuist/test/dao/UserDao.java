package com.nuist.test.dao;
// UserDao.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nuist.test.util.DbUtil;

public class UserDao implements UserDaoInterface {
	@Override
	public boolean registerUser(User user) {
		try (Connection connection = DbUtil.getConnection()) {
			String sql = "INSERT INTO user1 (username, password,createDate) VALUES (?, ?, ?)";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPassword());
				stmt.setString(3, user.getCreateDate());
				int rowsInserted = stmt.executeUpdate();
				return rowsInserted > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean loginUser(String username, String password) {
		try (Connection connection = DbUtil.getConnection()) {
			String sql = "SELECT * FROM user1 WHERE username = ? AND password = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, username);
				statement.setString(2, password);
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean query(String username) {
		try (Connection connection = DbUtil.getConnection()) {
			String sql = "SELECT * FROM user1 WHERE username = ? ";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, username);
				try (ResultSet resultSet = statement.executeQuery()) {
					return resultSet.next();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 获取注册时间的方法
	@Override
	public int queryId(String username) {
		try {
			// 获取数据库连接
			Connection connection = DbUtil.getConnection();
			// 执行查询语句
			String query = "SELECT id FROM user1 WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			// 获取注册时间
			if (resultSet.next()) {
				int createDate = resultSet.getInt("id");
				// 去除字符串时间后面的0
				return createDate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 获取注册时间的方法
	@Override
	public String queryRegisterDate(String username) {
		try {
			// 获取数据库连接
			Connection connection = DbUtil.getConnection();
			// 执行查询语句
			String query = "SELECT  createDate FROM user1 WHERE username = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			// 获取注册时间
			if (resultSet.next()) {
				String createDate = resultSet.getString("createDate");
				// 去除字符串时间后面的0
				createDate = createDate.replace(".0", "");
				return createDate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		UserDaoInterface userDao = new UserDao();

		System.out.println(userDao.queryRegisterDate("1"));
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate = format.format(date);
		System.out.println(createDate);

	}
}
