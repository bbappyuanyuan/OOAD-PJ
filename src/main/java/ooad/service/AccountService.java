package ooad.service;

import ooad.domain.Account;

public interface AccountService {

	public void addAccount(Account account);

	public Account findAccount(String name);
}
