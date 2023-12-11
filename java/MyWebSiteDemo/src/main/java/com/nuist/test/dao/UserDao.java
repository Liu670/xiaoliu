package com.nuist.test.dao;
// UserDao.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nuist.test.util.DbUtil;

public class UserDao implements UserDaoInterface {
	@Override
	public boolean registerUser(User user) {
		try (Connection connection = DbUtil.getConnection()) {
			String sql = "INSERT INTO user1 (username, password) VALUES (?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getPassword());
				int rowsInserted = statement.executeUpdate();
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

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.println(userDao.query("2"));
	}
}
