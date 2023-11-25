<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      strong {
        color: red;
      }
    </style>
  </head>
  <body>
    <form action="login.jsp" method="get">
      <h3>会员注册</h3>
      登录账号：<input type="text" name="user_code" id="user_code" /><strong
        >*</strong
      ><br />
      登录密码：<input type="password" name="password" id="password" /><strong
        >*</strong
      ><br />
      确认密码：<input
        type="password"
        name="repassword"
        id="repassword"
      /><strong>*</strong><br />
      性&emsp;&emsp;别：
      <select name="gender" id="gender">
        <option selected>--请选择--</option>
        <option value="男">男</option>
        <option value="女">女</option></select
      ><br />
      电子邮箱：<input type="email" name="email" id="email" /><strong>*</strong
      ><br />
      <input type="submit" value="注册" />
      <input type="button" value="返回" onclick="location='login.jsp'" />
    </form>
  </body>
  <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
    $(function () {
      $("form").submit(function () {
        var user_code = $("#user_code").val();
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        var gender = $("#gender").val();
        var email = $("#email").val();
        if (user_code == "") {
          alert("请输入登录账号");
          return false;
        }
        if (password == "") {
          alert("请输入登录密码");
          return false;
        }
        if (repassword == "") {
          alert("请输入确认密码");
          return false;
        }
        if (email == "") {
          alert("请输入邮箱");
          return false;
        }
        if (password !== repassword) {
          alert("两次密码不一致");
          return false;
        }
        if (user_code.length > 25 || user_code.length > 0) {
          alert("用户名长度在0-25之间");
          return false;
        }
        if (password.length < 6) {
          alert("密码长度必须大于6");
          return false;
        }
        if (email.indexOf("@") < 0) {
          alert("邮箱格式不正确");
          return false;
        }
      });
    });
  </script>
</html>
