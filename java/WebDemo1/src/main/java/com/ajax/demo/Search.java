package com.ajax.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");// 获得前端的请求账号密码，变成参数

		List<Map<String, String>> maplist = new ArrayList<>();
		String sqlget = "select * from user where account='" + account + "'and password=" + password;
		System.out.println(sqlget);
		maplist = mysqlUtil.show(sqlget, MysqlConfig.login);
		HttpSession session = request.getSession();
		String rep = "";
		if (maplist.size() > 0) {
			rep = "{\"code\":\"200\",\"message\":\"你好访问成功了\",\"data\":[";
			rep += "[" + "\"" + maplist.get(0).get("id") + "\"," + "\"" + maplist.get(0).get("account") + "\","
					+ maplist.get(0).get("password") + "]";
			rep += "]}";
			// System.out.println(maplist.get(0).get("account"));
			session.setAttribute("account", maplist.get(0).get("account"));
			// System.out.println("sessionId:"+session.getId()+"account"+
			// session.getAttribute("account"));
		} else {
			rep = "{\"code\":\"999999\",\"message\":\"对不起，没有相匹配的数据\"}";
		}

		System.out.println(rep);
		response.getWriter().write(rep);

	}

}