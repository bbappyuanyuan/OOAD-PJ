package ooad.repository;

import ooad.domain.BorrowRecord;

public interface BorrowRecordDao {

	public void save(BorrowRecord borrowRecord);

	public void update(BorrowRecord borrowRecord);
}
