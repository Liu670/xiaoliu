package com.nuist.test.servlet;
// LoginServlet.java

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nuist.test.dao.UserDao;
import com.nuist.test.util.MD5Util;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String enteredCaptcha = request.getParameter("captcha");
		String actualCaptcha = (String) request.getSession().getAttribute("captcha");

		// 验证验证码
		if (!enteredCaptcha.equals(actualCaptcha)) {
			response.sendRedirect("login.jsp?error=captcha");
			return;
		}

		// 对密码进行MD5加密
		String encryptedPassword = MD5Util.encrypt(password);

		UserDao userDao = new UserDao();
		if (userDao.loginUser(username, encryptedPassword)) {
//			HttpSession session = request.getSession();
			request.setAttribute("username", username);
			response.sendRedirect("http://liu.ihong.love:81");
		} else {
			response.sendRedirect("login.jsp?error=login");
		}
	}
}
