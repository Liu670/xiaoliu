/*
 * @Author: xiaoliu
 * @Date: 2023-12-14 19:57:10
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-15 01:54:30
 * @Description: file content
 * @FilePath: /code/Java/MyWebSiteDemo/src/main/java/com/nuist/test/servlet/LogoutServlet.java
 */
package com.nuist.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 功能：注销的实现
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 设置session和登录后进入首页
		session.setAttribute("username", null);
		// response.sendRedirect("pages/logout.html");
		// response.sendRedirect(request.getContextPath() + "/login.jsp");
		// // 解决iframe问题 iframe让父级页面跳转
		// response.getWriter().print("<script>top.location.href=/login.jsp</script>");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.open ('" + request.getContextPath() + "/login.jsp','_top')");
		out.println("</script>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}