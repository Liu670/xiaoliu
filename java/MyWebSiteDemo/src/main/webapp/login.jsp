<!-- login.jsp -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <html>

            <head>
                <title>Login Page</title>
                <!-- 添加样式链接等 -->
            </head>

            <body>
                <h2>Login</h2>
                <%-- 显示错误信息 --%>
                    <c:if test="${param.error == 'login'}">
                        <p style="color: red;">登录失败. 请检查你的账号或密码.</p>
                    </c:if>
                    <c:if test="${param.error == 'captcha'}">
                        <p style="color: red;">验证码错误. 请重试.</p>
                    </c:if>
                    <form action="LoginServlet" method="post">
                        Username: <input type="text" name="username" required><br>
                        Password: <input type="password" name="password" required><br>
                        Captcha: <input type="text" name="captcha" required>
                        <img src="CaptchaServlet" alt="Captcha Image"><br>
                        <input type="submit" value="Login">
                        <input type="button" value="Register">
                    </form>
            </body>

            </html>