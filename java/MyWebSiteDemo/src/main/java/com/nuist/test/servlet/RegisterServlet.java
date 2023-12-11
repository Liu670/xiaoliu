package com.nuist.test.servlet;
// RegisterServlet.java

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuist.test.dao.User;
import com.nuist.test.dao.UserDao;
import com.nuist.test.util.MD5Util;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
//		String enteredCaptcha = request.getParameter("captcha");
//		String actualCaptcha = (String) request.getSession().getAttribute("captcha");

		UserDao user = new UserDao();
		// 验证账号是否存在
		if (user.query(username)) {
			response.sendRedirect("login.html#register?error=isExist");
			return;
		}
		// 验证验证码
//		if (!enteredCaptcha.equals(actualCaptcha)) {
//			response.sendRedirect("register.jsp?error=captcha");
//			return;
//		}

		// 验证密码一致性
		if (!password.equals(confirmPassword)) {
			response.sendRedirect("login.html#register?error=password");
			return;
		}

		// 对密码进行MD5加密
		String encryptedPassword = MD5Util.encrypt(password);
		User newuser = new User();
		newuser.setUsername(username);
		newuser.setPassword(encryptedPassword);

		UserDao userDao = new UserDao();
		if (userDao.registerUser(newuser)) {
			response.sendRedirect("login.html#login?sussces");
		} else {
			response.sendRedirect("login.html#register?error=register");
		}
	}
}
