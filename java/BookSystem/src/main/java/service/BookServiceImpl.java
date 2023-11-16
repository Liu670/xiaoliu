package service;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.BookInfo;

public class BookServiceImpl implements BookService {
	BookDao dao = new BookDaoImpl();

	@Override
	public List<BookInfo> getBooks(int currentPage, int pageSize) {
		return dao.getBooks(currentPage, pageSize);
	}

	@Override
	public List<BookInfo> getBooksByCondition(BookInfo bookInfo, int currentPage, int pageSize) {
		return dao.getBooksByCondition(bookInfo, currentPage, pageSize);
	}

	@Override
	public int getBookInfoCount() {
		return dao.getBookInfoCount();
	}

}
