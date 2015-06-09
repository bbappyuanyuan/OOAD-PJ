package ooad.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.domain.URLComment;
import ooad.repository.URLCommentDao;

@Repository
public class URLCommentDaoImpl implements URLCommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(URLComment URLComment) {
		sessionFactory.getCurrentSession().save(URLComment);
	}

	@Override
	@Transactional
	public void update(URLComment URLComment) {
		sessionFactory.getCurrentSession().update(URLComment);
	}

}
