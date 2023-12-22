package com.nuist.test.dao;

// 增删改查
public interface UserDaoInterface {
	// 用户注册
	boolean registerUser(User user);

	// 用户登录
	boolean loginUser(String username, String password);

	// 用户查询
	boolean query(String username);

	// 获取用户id
	int queryId(String username);

	// 获取注册时间的方法
	String queryRegisterDate(String username);

}