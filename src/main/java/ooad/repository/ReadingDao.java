package ooad.repository;

import ooad.domain.Reading;

public interface ReadingDao {

	public void save(Reading reading);

	public void update(Reading reading);
}
