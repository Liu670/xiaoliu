package service;

import pojo.Users;

public interface UserService {
	// 登录
	public int login(Users user);

	// 注册
	public boolean regist(Users user);
}
