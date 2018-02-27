package com.mos.service;

import java.util.List;

import com.mos.domain.Account;

public interface AccountService {
	void createAccount(Account account);
	List<Account> findAll();
	Account findByAccountId(Integer accountId);
}
