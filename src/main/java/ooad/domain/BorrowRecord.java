package ooad.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "BORROW_RECORD")
public class BorrowRecord {

	private Integer id;
	private Date borrowDate;
	private Date returnDate;
	private Paperbook paperbook;
	private Account account;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	@Column(name = "borrow_date")
	public Date getBorrowDate() {
		return borrowDate;
	}

	@Column(name = "return_date")
	public Date getReturnDate() {
		return returnDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paperbook_id")
	public Paperbook getPaperBook() {
		return paperbook;
	}

	public BorrowRecord() {
	}

	public BorrowRecord(Date borrowDate, Date returnDate) {
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setPaperBook(Paperbook paperbook) {
		this.paperbook = paperbook;
	}
}
