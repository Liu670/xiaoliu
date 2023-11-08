<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<%	
	//post请求的编码格式
	//设置请求数据的编码格式
	/*request.setCharacterEncoding("utf-8");
	//设置响应数据的编码格式
	response.setCharacterEncoding("utf-8");*/
	
	
	%>

用户名:<% String username=request.getParameter("username");
	if(username!=null&&!username.equals("")){
		//将字符串通过iso-8859-1的格式转换成byte类型的数组
		byte [] userBytes=username.getBytes("iso-8859-1");
		//再将数组已utf-8的格式进行重组成字符串
		username=new String(userBytes,"UTF-8");
		out.print(username);
	}else{
		out.print("用户名未填写");
	}
%>
密码:<%=request.getParameter("password") %>
</body>
</html>