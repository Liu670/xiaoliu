package service;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Users;

public class UserServiceImpl implements UserService {
	BookDao dao = new BookDaoImpl();

	@Override
	public int login(Users user) {
		return dao.getUserByUsercodeAndPwd(user);
	}

	@Override
	public boolean regist(Users user) {
		// TODO Auto-generated method stub
		return dao.InsertUser(user);
	}

}
