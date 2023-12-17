package com.nuist.test.dao;

public interface UserDaoInterface {

	boolean registerUser(User user);

	boolean loginUser(String username, String password);

}