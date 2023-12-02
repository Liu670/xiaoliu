<%@page import="pojo.User"%>
<%@page import="util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= session.getId() %>
	<%
	User user = null;
	if (session.getAttribute("userName") == null) {
		response.sendRedirect("login.jsp");
	} else {
		user = (User) session.getAttribute("user");
	%>
	欢迎你<%=user.getUserName()%>,
	<%-- 
		目前共登录<%=Constants.userCount%>个用户
	 --%>
	 	目前共登录<%
	 	Object userCount = session.getServletContext().getAttribute("userCount");
	 	out.print(userCount.toString());
	 	%>个用户
	
	 <a href="loginout.jsp">离开</a>
	<%
	}
	%>

</body>
</html>