package ooad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ooad.domain.Book;
import ooad.repository.BookDao;
import ooad.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	public void addBook(Book book) {
		bookDao.save(book);
	}

	@Override
	public Book findBook(String title) {
		return bookDao.getBookByTitle(title);
	}

}
