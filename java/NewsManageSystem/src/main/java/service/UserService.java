package service;

import java.sql.SQLException;

import entity.User;

public interface UserService {
	public User doLogin(User user) throws SQLException;
}
