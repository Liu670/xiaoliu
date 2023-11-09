<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      label {
        display: block;
      }
      button {
        margin: 10px;
      }
    </style>
  </head>
  <body>
    <form action="">
      <h1>图书借阅系统</h1>
      <label for="username"
        >登录账号： <input type="text" id="username"
      /></label>
      <label for="password"
        >登录密码： <input type="password" id="password"
      /></label>
      <button type="submit">登录｜Login</button>
      <button type="button" onclick="reg()">注册用户</button>
    </form>
  </body>
</html>
<script>
  // 跳转注册页
  function reg() {
    location.href = "reg.jsp";
  }
  //
  function login() {
    location.href = "login.jsp";
  }
</script>
