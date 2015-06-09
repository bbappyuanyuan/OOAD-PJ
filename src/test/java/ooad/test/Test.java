package ooad.test;

import static org.junit.Assert.*;

import java.util.Set;

import ooad.domain.*;
import ooad.service.*;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	private static ApplicationContext context;
	private static AccountService accountService;
	private static BookService bookService;
	private static BorrowService borrowService;
	private static ReadingService readingService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames)
			System.out.println(beanName + " =========> "
					+ context.getBean(beanName).getClass().getName());
		accountService = context.getBean(AccountService.class);
		bookService = context.getBean(BookService.class);
		borrowService = context.getBean(BorrowService.class);
		readingService = context.getBean(ReadingService.class);
		addBooks();
		addAccounts();
	}

	public static void addBooks() {
		bookService.addBook(new Ebook("A Tale of Two Cities - EB",
				"Charles Dickens", "PLPH", Double.valueOf(14.10),
				"http://book.douban.com/subject/1007772/"));
		bookService.addBook(new Paperbook("A Tale of Two Cities - PB",
				"Charles Dickens", "PLPH", Double.valueOf(14.10), 2));
	}

	public static void addAccounts() {
		accountService.addAccount(new Account("Tinghang"));
	}

	@org.junit.Test
	public void useCase1() {
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

	@org.junit.Test
	public void useCase2() {
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
