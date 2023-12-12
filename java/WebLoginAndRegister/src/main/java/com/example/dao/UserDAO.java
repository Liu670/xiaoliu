package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.entity.User;
import com.example.util.DBConnector;

public class UserDAO {
	public UserDAO() {

	}

	public boolean addUser(User user) {
		try (Connection connection = DBConnector.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO user1 (username, password) VALUES (?, ?)")) {

			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validateUser(String username, String password) {
		try (Connection connection = DBConnector.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM user1 WHERE username = ? AND password = ?")) {

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
