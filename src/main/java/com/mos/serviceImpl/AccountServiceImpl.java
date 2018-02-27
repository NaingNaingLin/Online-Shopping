package com.mos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mos.domain.Account;
import com.mos.repository.AccountRepository;
import com.mos.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void createAccount(Account account) {
		accountRepository.saveAndFlush(account);
		
		
	}

	@Override
	public List<Account> findAll() {
		
		return accountRepository.findAll();
	}

	@Override
	public Account findByAccountId(Integer accountId) {
		
		return accountRepository.findOne(accountId);
	}

}
