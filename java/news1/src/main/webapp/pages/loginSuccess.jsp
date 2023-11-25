<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	用户名:
	<% String username=request.getParameter("username");
		if(username!=null&&!username.equals("")){
			out.println(username);
		}else{
			out.println("用户名未填写!");
		}
	%>
	<br/>
	密码:
	<% String password=request.getParameter("password");
		if(password!=null&&!password.equals("")){
			out.println(password);
		}else{
			out.println("用户密码未填写!");
		}
	%>
</body>
</html>