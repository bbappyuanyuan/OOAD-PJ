package ooad.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "READING")
public class Reading {

	private Integer id;
	private Integer start;
	private Integer end;
	private Book book;
	private Set<Note> notes = new HashSet<Note>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "start")
	public Integer getStart() {
		return start;
	}

	@Column(name = "end")
	public Integer getEnd() {
		return end;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	public Book getBook() {
		return book;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<Note> getNotes() {
		return notes;
	}

	public Reading() {
	}

	public Reading(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
}
