package com.test.util;

import java.sql.*;
import java.util.List;
public class DbUtils {
    private static final String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false";
    private static final String username = "root";
    private static final String password = "root";

    public static final String driver = "com.mysql.jdbc.Driver";

   static{
       try {
           Class.forName(driver);
       }catch (Exception e){
        e.printStackTrace();
       }
   }
// 打开数据库连接
   public static Connection open(){
       try {
           Connection conn=DriverManager.getConnection(url,username,password);
            return conn;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
   }

   // 预编译
    public static PreparedStatement preparedStatement(String sql,List param,Connection connection){
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            if(param!=null){
                for(int  i=0;i<param.size();i++){
                    statement.setObject(i+1,param.get(i));
                }
            }
            return statement;
        } catch (Exception e) {
           e.printStackTrace();
        }

        return null;
    }

    // 关闭资源
    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
       try{
           if(connection!=null){
               connection.close();
           }
           if(preparedStatement!=null){
               preparedStatement.close();
           }
           if(resultSet!=null){
               resultSet.close();
           }
       }catch (Exception e){
           e.printStackTrace();
       }

    }

    //
    public static int executeUpdate(String sql,List param){
       PreparedStatement statement = null;
       Connection connection = null;
       try{
           connection = DbUtils.open();
           statement = DbUtils.preparedStatement(sql,param,connection);
           return  statement.executeUpdate();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           DbUtils.closeAll(connection,statement,null);
       }
       return 0;
    }

}
