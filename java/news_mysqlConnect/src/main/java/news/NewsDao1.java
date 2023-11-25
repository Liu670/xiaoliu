package news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//java连接mysql
public class NewsDao1 {

	// 查询
	public void selectIdAndTitle() {

	}

	// 增加
	public void addNewsDetail(int id1, int cid1, String title1) {
		final String url = "jdbc:mysql://localhost:3306/kgcnews?useSSL=false", user = "root", passwd = "root";
		Connection conn = null;
		Statement stmt = null;
		try {
			// 1.加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.使用DriverManager获取数据库的连接
			conn = DriverManager.getConnection(url, user, passwd);
			// 3.发送SQL语句并获取结果集
//			String sql = "insert into news_detail (id,categoryId,title) values(" + id1 + "," + cid1 + "," + title1
//					+ ")";
			String str = "insert into news_detail (id,categoryId,title) values";
			String sql = str + String.format("(%d,%d,%s)", id1, cid1, title1);
			// 获取statement对象
			stmt = conn.createStatement();
			// 调用statement对象执行sql语句,将查询结果保存在resultSet结果集中
			try {
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					System.out.println("数据添加成功!");
				}
			} catch (Exception e) {
				System.out.println("出错啦!数据添加失败");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4.释放资源
		finally {
			try {

				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void addNewsDetail1(int id1, int cid1, String title1) {
		final String url = "jdbc:mysql://localhost:3306/kgcnews?useSSL=false", user = "root", passwd = "root";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// 1.加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.使用DriverManager获取数据库的连接
			conn = DriverManager.getConnection(url, user, passwd);
			// 3.发送SQL语句并获取结果集
			String sql = "insert into news_detail (id,categoryId,title) values(?,?,?)";
			// 获取statement对象
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cid1);
			stmt.setInt(2, cid1);
			stmt.setString(3, title1);
			// 调用statement对象执行sql语句,将查询结果保存在resultSet结果集中
			try {
				int num = stmt.executeUpdate(sql);
				if (num > 0) {
					System.out.println("数据添加成功!");
				}
			} catch (Exception e) {
				System.out.println("出错啦!数据添加失败");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4.释放资源
		finally {
			try {

				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	// 修改

	public static void main(String[] args) {
		new NewsDao1().addNewsDetail(5, 1, "1");
	}
}
