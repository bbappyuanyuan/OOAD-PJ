package ooad.repository;

import ooad.domain.Note;

public interface NoteDao {

	public void save(Note note);

	public void update(Note note);
}
