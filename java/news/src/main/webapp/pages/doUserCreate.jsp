<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户名:<%
// 转发:	request.getRequestDispatcher(url).forware(request,response);
// 重定向:	response.sendRedirect(url);
String username = request.getParameter("username");
if (username != null && username != "") {
	out.println(username);
	// 如果用户名为admin,转发到userCreate.jsp
	if (username.equals("admin")) {
		request.setAttribute("mess", "注册失败,用户名已使用");
		request.getRequestDispatcher("userCreate.jsp").forward(request, response);
	} else {
		request.setAttribute("mess", "注册成功");
		response.sendRedirect("newsDetail.jsp");
	}
	/* 
	request.getRequestDispatcher("").forward(arg0, arg1); 
	*/
} else {
	out.println("没有输入用户名!");
	response.sendRedirect("304.jsp");
}
%></br> 密码:<%=request.getParameter("password")%></br> 确认密码:<%=request.getParameter("con_password")%><br />
	邮箱：<%=request.getParameter("emai1")%><br /> 爱好:<%
String[] hobbys = request.getParameterValues("hobby");
if (hobbys != null && hobbys.length != 0) {
	for (String hobby : hobbys) {
		out.println(hobby);
	}
} else {
	out.println("没有选择爱好!");
}
%>
</body>
</html>