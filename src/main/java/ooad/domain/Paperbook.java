package ooad.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "PAPERBOOK")
public class Paperbook extends Book {

	private Integer count;
	private Set<BorrowRecord> borrowRecords = new HashSet<BorrowRecord>();

	@Column(name = "count")
	public Integer getCount() {
		return count;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<BorrowRecord> getBorrowRecords() {
		return borrowRecords;
	}

	public Paperbook() {
	}

	public Paperbook(String title, String author, String press, Double price,
			Integer count) {
		super(title, author, press, price);
		this.count = count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setBorrowRecords(Set<BorrowRecord> borrowRecords) {
		this.borrowRecords = borrowRecords;
	}

	public void incCount() {
		++count;
	}

	public void decCount() {
		--count;
	}
}
