package com.test.servlet;

import com.test.util.RequestUtil;
import com.test.util.SystemConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;

// 页面跳转
@WebServlet("/page")
public class PageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
    String page = RequestUtil.getString(request,"act");
    if(page!=null){
        // 默认首页
        page = "login";
    }
        try {
            request.getRequestDispatcher(SystemConstants.PAGE_PATH+page+".jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }
}
