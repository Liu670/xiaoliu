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

	<%
	String sql = "select * from score";
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	%>
	<%
	Statement stmt1 = conn.createStatement();
	// 获取表头 表结构
	String sql1 = "SELECT COLUMN_NAME, COLUMN_COMMENT FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + DB_NAME
			+ "' AND TABLE_NAME = '" + TABLE_NAME + "'";
	ResultSet rs1 = stmt1.executeQuery(sql1);
	String[] title = new String[rs.getMetaData().getColumnCount()];
	int i = 0;
	//  遍历 ResultSet 对象，获取字段和注释信息
	while (rs1.next()) {
		String columnName = rs1.getString("COLUMN_NAME"); // 获取字段名称
		String columnComment = rs1.getString("COLUMN_COMMENT"); // 获取注释信息
		title[i++] = columnName;
	}
	for (String s : title) {
		out.print(s);
	}
	%>
	<table border>
		<%
		while (rs.next()) {
			out.print("<tr>");
			out.print("<td>" + rs.getString("姓名") + "</td>");
			out.print("<td>" + rs.getString("准考证") + "</td>");
			out.print("<td>" + rs.getString("英语（二）") + "</td>");
			out.print("</tr>");
		}
		%>

	</table>

</body>
</html>