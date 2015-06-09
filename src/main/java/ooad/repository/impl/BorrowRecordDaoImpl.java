package ooad.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.domain.BorrowRecord;
import ooad.repository.BorrowRecordDao;

@Repository
public class BorrowRecordDaoImpl implements BorrowRecordDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(BorrowRecord borrowRecord) {
		sessionFactory.getCurrentSession().save(borrowRecord);
	}

	@Override
	@Transactional
	public void update(BorrowRecord borrowRecord) {
		sessionFactory.getCurrentSession().update(borrowRecord);
	}

}
