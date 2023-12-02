package com.test.servlet;

import com.test.dao.UserDao;
import com.test.pojo.User;
import com.test.util.RequestUtil;
import com.test.util.SystemConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 处理注册的请求
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = RequestUtil.getString(req,"username");
    if(username == null || "".equals(username)){
        error("用户名不能为空",req,resp);
    }

    String password = RequestUtil.getString(req,"password");
    if(password == null || "".equals(password)){
        error("密码不能为空",req,resp);
    }
    String nickname = RequestUtil.getString(req,"nickname");
    if(nickname == null || "".equals(nickname)){
        error("昵称不能为空",req,resp);
    }
    String repassword = RequestUtil.getString(req,"repwd");
    if(nickname == null || "".equals(nickname)){
        error("再次输入密码不能为空",req,resp);
    }
    if(password.equals(repassword)){
        error("两次密码不匹配",req,resp);
    }
    // 查询数据库中的用户
        User user = userDao.getUserByUsername(username);
        if(user!=null){
            error("用户名已存在",req,resp);
            return ;
        }
        user = new User();
        user.setNickname(nickname);
        user.setUsername(username);
        user.setPassword(password);
        int result = userDao.add(user);
        if(result==1){
            req.getRequestDispatcher(SystemConstants.PAGE_PATH+"login.jsp").forward(req,resp);
        }else{
            error("修改失败，请稍后再试",req,resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void error(String message,HttpServletRequest req,HttpServletResponse resp){
        req.setAttribute("message",message);
        try {
            req.getRequestDispatcher(SystemConstants.PAGE_PATH+"register.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ;
    }

    }
