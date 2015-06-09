package ooad.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Book {

	protected Integer id;
	protected String title;
	protected String author;
	protected String press;
	protected Double price;
	protected Set<URLComment> URLComments = new HashSet<URLComment>();
	protected Set<Reading> readings = new HashSet<Reading>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	@Column(name = "press")
	public String getPress() {
		return press;
	}

	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<URLComment> getURLComments() {
		return URLComments;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<Reading> getReadings() {
		return readings;
	}

	public Book() {
	}

	public Book(String title, String author, String press, Double price) {
		this.title = title;
		this.author = author;
		this.press = press;
		this.price = price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setURLComments(Set<URLComment> URLComments) {
		this.URLComments = URLComments;
	}

	public void setReadings(Set<Reading> readings) {
		this.readings = readings;
	}
}
