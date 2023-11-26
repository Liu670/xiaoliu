package loginAndRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class demo {
	public static void main(String[] args) throws SQLException, JSONException {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 驱动程序名
			// com.mysql.jdbc.cj.Driver也是OK的
			String url = "jdbc:mysql://localhost:3306/test"; // 数据库名 ？后面的是为了指定字符的编码、解码格式。
			String username = "root"; // 数据库用户名
			String password = "root"; // 数据库用户密码
			Connection conn = DriverManager.getConnection(url, username, password); // 连接状态

			if (conn != null) {
				Statement stmt = null;
				ResultSet rs = null;
				String n = "1";
				String sql = "SELECT *FROM user where uname=" + n + ";"; // 查询语句
				System.out.println(sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				System.out.println("size:" + rs.getCursorName());
				// 新建JSON对象
				JSONArray ReturnJson = new JSONArray();
				while (rs.next()) {
					System.out.println(rs.getString("uname"));
					System.out.println(rs.getString("upwd"));
					/*
					 * out.println(rs.getString("uname")+"   &nbsp  "+rs.getString("upwd"));
					 * //将查询结果输出 out.print("<br/>");
					 */
					JSONObject JsonTmp = new JSONObject();
					// 添加键值对数据
					JsonTmp.put("name", rs.getString("uname"));
					JsonTmp.put("password", rs.getString("upwd"));
					// 设置数据返回头类型为JSON格式
					ReturnJson.put(JsonTmp);
				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
