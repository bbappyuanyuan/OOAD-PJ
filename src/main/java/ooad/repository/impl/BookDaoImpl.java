package ooad.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.domain.Book;
import ooad.repository.BookDao;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Book book) {
		sessionFactory.getCurrentSession().save(book);
	}

	@Override
	@Transactional
	public void update(Book book) {
		sessionFactory.getCurrentSession().update(book);
	}

	@Override
	@Transactional
	public Book getBookByTitle(String title) {
		String hql = "FROM ooad.domain.Book A WHERE A.title = :title";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("title", title);
		List<?> result = query.list();
		if (result != null && result.size() > 0)
			return (Book) result.get(0);
		return null;
	}
}
