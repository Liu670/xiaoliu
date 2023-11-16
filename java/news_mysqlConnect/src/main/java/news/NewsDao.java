package news;

import java.sql.*;

//java连接mysql
public class NewsDao {
	public static void main(String[] args) {
		final String url = "jdbc:mysql://localhost:3306/kgcnews?useSSL=false", user = "root", passwd = "root";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.使用DriverManager获取数据库的连接
			conn = DriverManager.getConnection(url, user, passwd);
			// 3.发送SQL语句并获取结果集
			String sql = "select id,title from news_detail";
			// 获取statement对象
			stmt = conn.createStatement();
			// 调用statement对象执行sql语句,将查询结果保存在resultSet结果集中
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				System.out.printf("%d:%s\n", id, title);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4.释放资源
		finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
