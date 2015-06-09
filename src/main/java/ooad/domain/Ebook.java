package ooad.domain;

import javax.persistence.*;

@Entity
@Table(name = "EBOOK")
public class Ebook extends Book {

	private String URI;

	@Column(name = "URI")
	public String getURI() {
		return URI;
	}

	public Ebook() {
	}

	public Ebook(String title, String author, String press, Double price,
			String URI) {
		super(title, author, press, price);
		this.URI = URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}
}
