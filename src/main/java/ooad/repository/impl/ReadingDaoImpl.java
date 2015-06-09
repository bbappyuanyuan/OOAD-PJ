package ooad.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.domain.Reading;
import ooad.repository.ReadingDao;

@Repository
public class ReadingDaoImpl implements ReadingDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Reading reading) {
		sessionFactory.getCurrentSession().save(reading);
	}

	@Override
	@Transactional
	public void update(Reading reading) {
		sessionFactory.getCurrentSession().update(reading);
	}

}
