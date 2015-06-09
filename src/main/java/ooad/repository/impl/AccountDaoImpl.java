package ooad.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.domain.Account;
import ooad.repository.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Account account) {
		sessionFactory.getCurrentSession().save(account);
	}

	@Override
	@Transactional
	public void update(Account account) {
		sessionFactory.getCurrentSession().update(account);
	}

	@Override
	@Transactional
	public Account getAccountByName(String name) {
		String hql = "FROM ooad.domain.Account A WHERE A.name = :name";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("name", name);
		List<?> result = query.list();
		if (result != null && result.size() > 0)
			return (Account) result.get(0);
		return null;
	}
}
