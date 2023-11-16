package dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.BaseDao;
import dao.BookDao;
import pojo.BookInfo;
import pojo.BookType;
import pojo.Users;

public class BookDaoImpl extends BaseDao implements BookDao {
	@Override
	public boolean InsertUser(Users user) {
		try {
			String sql = "insert into users (user_code,`password`,email,gender"
					+ ",register_time,last_logintime)values(?,?,?,?,?,?)";
			Object[] params = { user.getUser_code(), user.getPassword(), user.getEmail(), user.getGender(),
					user.getRegister_time(), user.getLast_logintime() };
			int updateRows = this.executeUpdate(sql, params);
			if (updateRows <= 0) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return true;
	}

	@Override
	public Users getUserByUsercodeAndPwd(Users user) {
		int count = 1;
		try {
			String sql = "select count(1) from users where user_code=? and `password`=?";
			Object[] params = { user.getUser_code(), user.getPassword() };
			ResultSet rs = this.executeQuery(sql, params);
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return user;
	}

	@Override
	public List<BookInfo> getBooks(int currentPage, int pageSize) {
		List<BookInfo> booklist = new ArrayList<BookInfo>();
		try {
			String sql = "select book_code,type_name,book_name,book_author,publish_press,is_borrow"
					+ " from book_info inner join book_type on book_info.book_type=book_type.id limit ?,?";
			Object[] params = { (currentPage - 1) * pageSize };
			ResultSet rs = this.executeQuery(sql, params);
			while (rs.next()) {
				String book_code = rs.getString(1);
				String type_name = rs.getString(2);
				String book_name = rs.getString(3);
				String book_author = rs.getString(4);
				String publish_press = rs.getString(5);
				int is_borrow = rs.getInt(6);
				BookType booktype = new BookType();
				booktype.setType_name(type_name);

				BookInfo book = new BookInfo();
				book.setBook_code(book_code);
//				book.setBook_type(booktype);
				book.setBook_name(book_name);
				book.setBook_author(book_author);
				book.setPublish_press(publish_press);
				book.setIs_borrow(is_borrow);
				booklist.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return booklist;
	}

	@Override
	public List<BookInfo> getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookInfo> getBooksByCondition(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBookInfoCount() {
		int count = -1;
		try {
			String sql = "select count(1) from `book_info`";
			Object[] params = {};
			ResultSet rs = this.executeQuery(sql, params);
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return count;
	}

	public static void main(String[] args) {
		BookDao dao = new BookDaoImpl();
		Users users = new Users(4, "haimianbaobao", "54321", "haimianbaobao@qq.com", "男", new Date(), new Date());
//		dao.InsertUser(users);
		List<BookInfo> bookInfos = dao.getBooks(2, 5);
		for (BookInfo book : bookInfos) {
			System.out.println(book.toString());
		}
	}
}
