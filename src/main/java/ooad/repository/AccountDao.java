package ooad.repository;

import ooad.domain.Account;

public interface AccountDao {

	public void save(Account account);

	public void update(Account account);

	public Account getAccountByName(String name);
}
