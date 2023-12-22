package com.nuist.test.servlet;
// RegisterServlet.java

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuist.test.dao.User;
import com.nuist.test.dao.UserDao;
import com.nuist.test.dao.UserDaoInterface;
import com.nuist.test.util.MD5Util;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/javascript"); // 对于 JS 文件
		response.setContentType("text/css"); // 对于 CSS 文件

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
//		String enteredCaptcha = request.getParameter("captcha");
//		String actualCaptcha = (String) request.getSession().getAttribute("captcha");

		UserDao user = new UserDao();
		// 验证账号是否存在
		if (user.query(username)) {
			response.sendRedirect("login.jsp?error=isExist#register");
			return;
		}
		// 验证验证码
//		if (!enteredCaptcha.equals(actualCaptcha)) {
//			response.sendRedirect("register.jsp?error=captcha");
//			return;
//		}

		// 验证密码一致性
		if (!password.equals(confirmPassword)) {
			response.sendRedirect("login.jsp?error=password#register");
			return;
		}

		// 创建时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate = format.format(date);
		// 对密码进行MD5加密
		String encryptedPassword = MD5Util.encrypt(password);
		User newuser = new User();
		newuser.setUsername(username);
		newuser.setPassword(encryptedPassword);
		newuser.setCreateDate(createDate);

		UserDaoInterface userDao = new UserDao();
		if (userDao.registerUser(newuser)) {
			response.sendRedirect("login.jsp?sussces#login");
		} else {
			response.sendRedirect("login.jsp?error=register#register");
		}
	}
}
