<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.json.*"%>
<%

    try {
     	response.addHeader("Access-Control-Allow-Origin", "*");

        Class.forName("com.mysql.jdbc.Driver");  //驱动程序名
        //com.mysql.jdbc.cj.Driver也是OK的
        String url = "jdbc:mysql://localhost:3306/test"; //数据库名 ？后面的是为了指定字符的编码、解码格式。
        String username = "root";  //数据库用户名
        String password = "root";  //数据库用户密码
        Connection conn = DriverManager.getConnection(url, username, password);  //连接状态
 
        if(conn != null){/* 
            out.println("数据库连接成功！");
            out.print("<br />"); */
            Statement stmt = null;
            ResultSet rs = null;
            String sql = "SELECT *FROM user;";  //查询语句
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
     /*        out.print("查询结果：");
            out.print("<br />");
            out.println("用户名"+"  "+"密码");
            out.print("<br />"); */
            //新建JSON对象
            JSONArray ReturnJson=new JSONArray();
            while (rs.next()) {
                    /* out.println(rs.getString("uname")+"   &nbsp  "+rs.getString("upwd")); //将查询结果输出
                    out.print("<br/>"); */
                    JSONObject JsonTmp=new JSONObject();
                    //添加键值对数据
                    JsonTmp.put("name", rs.getString("uname"));
                    JsonTmp.put("password", rs.getString("upwd"));
                    //设置数据返回头类型为JSON格式
                    response.setContentType("application/json;charset=utf-8");
                  ReturnJson.put(JsonTmp);
                } 
            /* 解决跨域问题 */

            response.getWriter().write(ReturnJson.toString());
 }
        
      }
    catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
//    catch (SQLException e)
//          {
//        e.printStackTrace();
//    }
%>