package service;

import java.util.List;

import pojo.BookInfo;

public interface BookService {
	// 查询全部图书信息
	public List<BookInfo> getBooks(int currentPage, int pageSize);

	// 按条件查询图书信息（查询条件包括：图书分类、图书名称、是否借阅）
	public List<BookInfo> getBooksByCondition(BookInfo bookInfo, int currentPage, int pageSize);

	// 查询图书信息的记录数
	public int getBookInfoCount();
}
