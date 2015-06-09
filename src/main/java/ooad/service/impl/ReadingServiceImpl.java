package ooad.service.impl;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ooad.domain.Book;
import ooad.domain.Ebook;
import ooad.domain.Note;
import ooad.domain.Paperbook;
import ooad.domain.Reading;
import ooad.domain.URLComment;
import ooad.repository.BookDao;
import ooad.repository.NoteDao;
import ooad.repository.ReadingDao;
import ooad.repository.URLCommentDao;
import ooad.service.ReadingService;

@Service
public class ReadingServiceImpl implements ReadingService {

	@Autowired
	BookDao bookDao;
	@Autowired
	ReadingDao readingDao;
	@Autowired
	NoteDao noteDao;
	@Autowired
	URLCommentDao URLCommentDao;

	@Override
	public boolean isAvailable(Book book) {
		if (book instanceof Ebook)
			return true;
		Paperbook paperbook = (Paperbook) book;
		return paperbook.getCount().intValue() > 0;
	}

	@Override
	public Reading readBook(Book book) {
		int start = 0;
		for (Reading reading : book.getReadings())
			if (reading.getEnd().intValue() > start)
				start = reading.getEnd().intValue();
		Reading reading = new Reading(Integer.valueOf(start), null);
		readingDao.save(reading);
		book.getReadings().add(reading);
		if (book instanceof Paperbook)
			((Paperbook) book).decCount();
		bookDao.update(book);
		return reading;
	}

	@Override
	public void takeNote(Reading reading, String content) {
		Note note = new Note(content, new Date());
		noteDao.save(note);
		reading.getNotes().add(note);
		readingDao.update(reading);
	}

	@Override
	public void makeComment(Book book, String URI) {
		URLComment URLComment = new URLComment(URI, new Date());
		URLCommentDao.save(URLComment);
		book.getURLComments().add(URLComment);
		bookDao.update(book);
	}

	@Override
	public Set<URLComment> lookUpComment(Book book) {
		return book.getURLComments();
	}

	@Override
	public Set<Note> lookUpNote(Reading reading) {
		return reading.getNotes();
	}

	@Override
	public void finishReadingBook(Reading reading, int end) {
		reading.setEnd(Integer.valueOf(end));
		readingDao.update(reading);
		Book book = reading.getBook();
		if (book instanceof Paperbook) {
			((Paperbook) book).incCount();
			bookDao.update(book);
		}
	}

}
