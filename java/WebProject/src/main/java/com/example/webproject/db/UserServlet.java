package com.example.webproject.db;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取前端的请求参数 获取从前端传入的参数内容
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
		System.out.println(1);
		String reqInfoString = request.getReader().readLine();
		JSONObject obj = (JSONObject) JSONObject.parse(reqInfoString);
		System.out.println(obj + "--" + reqInfoString);
		String username = obj.getString("username");
		String password = obj.getString("password");
		System.out.println(username);

		// 请求数据 到数据库查找User对象
		Connection conn = DBConnection.getConnection();
		String sql = "select * from user where username='" + username + "'";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				String name = rs.getString("username");
				String pass = rs.getString("password");
				if (password.equals(pass)) {
					Message msg = new Message();
					msg.setInfo("登录成功");
					msg.setCode(200);
					Writer writer = response.getWriter();
					writer.append(msg.json());
					writer.close();
				} else {
					Message msg = new Message();
					msg.setInfo("密码不正确");
					msg.setCode(500);
					Writer writer = response.getWriter();
					writer.append(msg.json());
					writer.close();
				}
			} else {
				Message msg = new Message();
				msg.setInfo("用户名不正确");
				msg.setCode(500);
				Writer writer = response.getWriter();
				writer.append(msg.json());
				writer.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public UserServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
