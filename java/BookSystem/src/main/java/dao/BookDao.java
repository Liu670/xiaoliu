package dao;

import java.util.List;

import pojo.BookInfo;
import pojo.Users;

public interface BookDao {

	// 添加用户
	public boolean InsertUser(Users user);

	// 根据用户名和密码，查询用户对象
	public int getUserByUsercodeAndPwd(Users user);

	// 查询全部图书信息
	public List<BookInfo> getBooks();

	// 查询当前页图书信息
	public List<BookInfo> getBooks(int currentPage, int pageSize);

	// 按条件查询图书信息（查询条件包括：图书分类，图书名称，是否借阅）
	public List<BookInfo> getBooksByCondition(BookInfo bookInfo, int currentPage, int pageSize);

	// 查询图书信息的记录数
	public int getBookInfoCount();
}
