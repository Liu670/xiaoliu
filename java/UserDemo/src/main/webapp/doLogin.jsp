<%@page import="pojo.User"%>
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
  	String userName=request.getParameter("userCode");
	String password=request.getParameter("userPassword");	
	if(userName==null||"".equals(userName)
			||password==null||"".equals(password)){
		response.sendRedirect("login.jsp");
	}else{
		System.out.println(userName);
		System.out.println(password);
		User user=new User(userName,password);
		session.setAttribute("user", user); 
		response.sendRedirect("online.jsp"); 
	}
%>
</body>
</html>