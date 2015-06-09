package ooad.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	private Integer id;
	private String name;
	private Set<BorrowRecord> borrowRecords = new HashSet<BorrowRecord>();

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<BorrowRecord> getBorrowRecords() {
		return borrowRecords;
	}

	public Account() {
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBorrowRecords(Set<BorrowRecord> borrowRecords) {
		this.borrowRecords = borrowRecords;
	}
}
