package ooad.test;

import static org.junit.Assert.*;

import java.util.Set;

import ooad.domain.*;
import ooad.service.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UC {

	@Autowired
	private AccountService accountService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BorrowService borrowService;
	@Autowired
	private ReadingService readingService;

	@Test
	public void test0_showBeans() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames)
			System.out.println(beanName + " =========> "
					+ context.getBean(beanName).getClass().getName());
	}

	@Test
	public void test1_addBooks() {
		bookService.addBook(new Ebook("A Tale of Two Cities - EB",
				"Charles Dickens", "PLPH", Double.valueOf(14.10),
				"http://book.douban.com/subject/1007772/"));
		bookService.addBook(new Paperbook("A Tale of Two Cities - PB",
				"Charles Dickens", "PLPH", Double.valueOf(14.10), 2));
	}

	@Test
	public void test2_addAccounts() {
		accountService.addAccount(new Account("Tinghang"));
	}

	@Test
	public void test3_useCase1() {
		Book book = bookService.findBook("A Tale of Two Cities - EB");
		assertTrue(book != null);
		assertTrue(book instanceof Ebook);
		if (readingService.isAvailable(book))
			System.out.println("available book");
		else
			fail("unavailable book");
		Reading reading = readingService.readBook(book);
		assertTrue(reading != null);
		int page = reading.getStart().intValue();
		System.out.println("start reading from page " + page);
		readingService.makeComment(book, "google.com");
		readingService.makeComment(book, "bing.com");
		readingService.takeNote(reading, "I no longer believe in love.");
		readingService.takeNote(reading, "I come to believe in love.");
		Set<URLComment> cms = readingService.lookUpComment(book);
		for (URLComment cm : cms)
			System.out.println("comment: " + cm.getURI());
		Set<Note> nts = readingService.lookUpNote(reading);
		for (Note nt : nts)
			System.out.println("note: " + nt.getContent());
		readingService.finishReadingBook(reading, page + 20);
	}

	@Test
	public void test4_useCase2() {
		Book book = bookService.findBook("A Tale of Two Cities - PB");
		assertTrue(book != null);
		assertTrue(book instanceof Paperbook);
		Paperbook paperbook = (Paperbook) book;
		if (borrowService.isBorrowable(paperbook))
			System.out.println("borrowable book");
		else
			fail("unborrowable (is Ebook)");
		Account account = accountService.findAccount("Tinghang");
		assertTrue(account != null);
		BorrowRecord borrowRecord = borrowService
				.borrowBook(account, paperbook);
		assertTrue(borrowRecord != null);
		borrowService.returnBook(borrowRecord);
	}

}
