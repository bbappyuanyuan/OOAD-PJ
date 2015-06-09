package ooad.service;

import ooad.domain.Book;

public interface BookService {

	public void addBook(Book book);

	public Book findBook(String title);
}
