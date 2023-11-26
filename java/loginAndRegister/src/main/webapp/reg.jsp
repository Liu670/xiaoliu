<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="java.sql.*" %>
<%
/* 解决跨域 */
//response.addHeader("Access-Control-Allow-Origin", "*");

  // 获取前端发送的数据
  String uname = request.getParameter("username");
  String upwd = request.getParameter("password1");
  System.out.println(uname);
  System.out.println(upwd);
 //out.println(uname);
 //out.println(upwd);
  // 连接数据库
  Connection conn = null;
  Statement stmt = null;
  // 用于查询用
  Statement stmt1 = null;
  ResultSet rs = null;
  try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    stmt = conn.createStatement();
    //stmt1 = conn.createStatement();
	//String sql1 = "SELECT *FROM user where uname=" + n + ";"; // 查询语句
	//String name,password;
    //rs = stmt1.executeQuery(sql1);
    	//response.getWriter().write("账号已存在");
  	response.addHeader("Access-Control-Allow-Origin", "*");
	String sql = "INSERT INTO user (uname,upwd) VALUES (" + uname + ','+upwd +")";
	stmt.executeUpdate(sql);


  } catch (Exception e) {
    //out.println("写入数据库时发生错误：" + e.getMessage());
  } finally {
    // 关闭数据库连接
    try {
      if (stmt != null) stmt.close();
      if (conn != null) conn.close();
    } catch (SQLException e) {
      //out.println("关闭数据库连接时发生错误：" + e.getMessage());
    }
  }
%>