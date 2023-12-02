<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form  action="doLogin.jsp"  name="actionForm" id="actionForm"  
			method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd>
					<input type="text" id="userCode" name="userCode"/> 
					<span id="userCodeSpan"></span> 
				</dd>
				<dt>密　码：</dt>
				<dd>
					<input type="password"  id="userPassword" name="userPassword"/>
					<span id="userPasswordSpan"></span>
				</dd>
			</dl>
			<div class="buttons">
			    ${error }
				<input type="submit"  value="登录系统" />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>


</body>
</html>