package ooad.service;

import ooad.domain.BorrowRecord;
import ooad.domain.Account;
import ooad.domain.Paperbook;

public interface BorrowService {

	public boolean isBorrowable(Paperbook paperbook);

	public BorrowRecord borrowBook(Account account, Paperbook paperbook);

	public void returnBook(BorrowRecord borrowRecord);
}
