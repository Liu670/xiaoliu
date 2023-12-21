<!--
 * @Author: xiaoliu
 * @Date: 2023-12-11 23:19:04
 * @LastEditors: xiaoliu
 * @LastEditTime: 2023-12-15 01:57:32
 * @Description: file content
 * @FilePath: /code/Java/MyWebSiteDemo/src/main/webapp/pages/setting.html
-->
  <%@page import="com.nuist.test.dao.UserDao"%>
<%@page import="com.nuist.test.dao.UserDaoInterface"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>设置中心</title>
    <style>
        @import url("css/user.css?v=1.0");
    </style>
</head>

<body>
    <header>
        <h1>账号设置</h1>
    </header>


    <section>
        <h2>欢迎，${sessionScope.username} ！</h2>
        <p>您已成功登录。以下是您的个人信息：</p>
        <ul>
            <li><strong>用户ID：</strong>
            <%
            	// 获取用户时间
				UserDaoInterface u = new UserDao();
				out.println(u.queryId((String)session.getAttribute("username")));
			%>
            </li>
            <li><strong>用户名：</strong> ${sessionScope.username}</li>
            <li><strong>注册时间：</strong> 
            <%
            	// 获取注册时间
				out.println(u.queryRegisterDate((String)session.getAttribute("username")));
			%>
			</li>
        </ul>
        <p></p>
        <!-- 账号注销 跳转登录页面 -->
        <form action="/MyWebSiteDemo/LogoutServlet" method="post">
            <button type="submit">注销</button>
            <!-- <input type="submit" value="logout"> -->
        </form>
    </section>

    <script>
        function logout() {
            // 添加注销逻辑，例如跳转到注销页面或触发注销操作
            alert("注销成功！");
            window.location.href = "home.html";
        }
    </script>
</body>

</html>