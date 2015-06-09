package ooad.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "URL_COMMENT")
public class URLComment {

	private Integer id;
	private String URI;
	private Date date;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "URI")
	public String getURI() {
		return URI;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public URLComment() {
	}

	public URLComment(String URI, Date date) {
		this.URI = URI;
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
