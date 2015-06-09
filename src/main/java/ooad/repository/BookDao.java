package ooad.repository;

import ooad.domain.Book;

public interface BookDao {

	public void save(Book book);

	public void update(Book book);

	public Book getBookByTitle(String title);
}
