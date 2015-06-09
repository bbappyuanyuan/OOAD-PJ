package ooad.service;

import java.util.Set;

import ooad.domain.Book;
import ooad.domain.Note;
import ooad.domain.Reading;
import ooad.domain.URLComment;

public interface ReadingService {

	public boolean isAvailable(Book book);

	public Reading readBook(Book book);

	public void takeNote(Reading reading, String content);

	public void makeComment(Book book, String URI);

	public Set<URLComment> lookUpComment(Book book);

	public Set<Note> lookUpNote(Reading reading);

	public void finishReadingBook(Reading reading, int end);
}
