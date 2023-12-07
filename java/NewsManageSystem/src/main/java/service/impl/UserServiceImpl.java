package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import util.DatabaseUtil;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = DatabaseUtil.getConnection();

			return new UserDaoImpl(conn).findUser(user.getUname(), user.getUpwd());
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DatabaseUtil.closeAll(conn, null, null);
		}
	}

}
