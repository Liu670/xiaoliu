<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		//清除session
		//session.invalidate();
		
		//清除session属性
		session.removeAttribute("mess");
		response.sendRedirect("newsDetail.jsp");
%>
</body>
</html>