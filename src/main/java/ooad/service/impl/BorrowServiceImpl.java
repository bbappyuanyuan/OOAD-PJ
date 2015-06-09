package ooad.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ooad.domain.Account;
import ooad.domain.BorrowRecord;
import ooad.domain.Paperbook;
import ooad.repository.BorrowRecordDao;
import ooad.repository.AccountDao;
import ooad.service.BorrowService;

@Service
public class BorrowServiceImpl implements BorrowService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	BorrowRecordDao borrowRecordDao;

	@Override
	public boolean isBorrowable(Paperbook paperbook) {
		return paperbook.getCount().intValue() > 0;
	}

	@Override
	public BorrowRecord borrowBook(Account account, Paperbook paperbook) {
		BorrowRecord borrowRecord = new BorrowRecord(new Date(), null);
		borrowRecord.setAccount(account);
		borrowRecord.setPaperBook(paperbook);
		borrowRecordDao.save(borrowRecord);
		return borrowRecord;
	}

	@Override
	public void returnBook(BorrowRecord borrowRecord) {
		borrowRecord.setReturnDate(new Date());
		borrowRecordDao.update(borrowRecord);
	}

}
