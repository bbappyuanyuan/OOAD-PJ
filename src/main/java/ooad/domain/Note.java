package ooad.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "NOTE")
public class Note {

	private Integer id;
	private String content;
	private Date date;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public Note() {
	}

	public Note(String content, Date date) {
		this.content = content;
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
