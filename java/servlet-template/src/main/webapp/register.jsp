<%--
  Created by IntelliJ IDEA.
  User: liu
  Date: 2023/12/1
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form method="post" action="<%=request.getContextPath()%>/register">
        <table align="center">
            <tr align="center">
                <td colspan="2">
                    <h1>注册</h1>
                </td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input name="username" value="${param.username}"></td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input name="nickname" value="${param.nickname}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" value="${param.password}"></td>
            </tr>
            <tr>
                <td>确定密码</td>
                <td><input type="password" name="repassword" value="${param.repassword}"></td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="注册">
                    <a href="<%=request.getContextPath()%>/login">登录</a>
                </td>
            </tr>

            <tr>
                <td colspan="2">${message}</td>
            </tr>

        </table>

    </form>
</body>
</html>
