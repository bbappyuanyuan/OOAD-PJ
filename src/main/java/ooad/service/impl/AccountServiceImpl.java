package ooad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ooad.domain.Account;
import ooad.repository.AccountDao;
import ooad.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public void addAccount(Account account) {
		accountDao.save(account);
	}

	@Override
	public Account findAccount(String name) {
		return accountDao.getAccountByName(name);
	}

}
