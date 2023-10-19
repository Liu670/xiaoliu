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
		String username = request.getParameter("username");
		if(username!=null && username != ""){
			out.println(username);
		}else{
			out.println("没有输入用户名!");
		}
	%></br> 
	密码:<%=request.getParameter("password")%></br>
	确认密码:<%=request.getParameter("con_password")%><br /> 
	邮箱：<%=request.getParameter("emai1")%><br />
	爱好:<%
	String[] hobbys = request.getParameterValues("hobby");
		if(hobbys!=null&&hobbys.length!=0){
			for (String hobby : hobbys) {
				out.println(hobby);
			}
		}else{
			out.println("没有选择爱好!");
		}
%>
</body>
</html>