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
	int i = 0;
	%>

	<%!public int getSum() {
		return 3 + 3;
	}%>
	<%=getSum() %>

	<%!int j = 0;%>

	<%=i++%>
	<%=j++%>
</body>
</html>