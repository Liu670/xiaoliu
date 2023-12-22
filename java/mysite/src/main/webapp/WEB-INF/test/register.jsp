<!-- register.jsp -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Register Page</title>
    <!-- 添加样式链接等 -->
</head>
<body>
    <h2>Register</h2>
    <%-- 显示错误信息 --%>
    <c:if test="${param.error == 'register'}">
        <p style="color: red;">注册失败. 请重试.</p>
    </c:if>
    <c:if test="${param.error == 'password'}">
        <p style="color: red;">密码不匹配. 请重试.</p>
    </c:if>
    <c:if test="${param.error == 'captcha'}">
        <p style="color: red;">验证码错误. 请重试.</p>
    </c:if>
    <form action="RegisterServlet" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        Confirm Password: <input type="password" name="confirmPassword" required><br>
        Captcha: <input type="text" name="captcha" required>
        <img src="CaptchaServlet" alt="Captcha Image"><br>
        <input type="submit" value="Register" id="Register">
    </form>
</body>
</html>
<script>
	Register.onclick = function(){
	
}
</script>
