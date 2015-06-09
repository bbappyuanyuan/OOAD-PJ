package ooad.repository.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ooad.domain.Note;
import ooad.repository.NoteDao;

@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Note note) {
		sessionFactory.getCurrentSession().save(note);
	}

	@Override
	@Transactional
	public void update(Note note) {
		sessionFactory.getCurrentSession().update(note);
	}

}
