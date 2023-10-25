<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 建立连接
	String DB_NAME = "score";
	String TABLE_NAME = "score";

	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/score";
	String name = "root";
	String password = "root";
	Connection conn = DriverManager.getConnection(url, name, password);
	%>
</body>
</html>