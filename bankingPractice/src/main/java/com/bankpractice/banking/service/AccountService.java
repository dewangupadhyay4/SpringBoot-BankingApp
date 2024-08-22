package com.bankpractice.banking.service;

import com.bankpractice.banking.dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);

	AccountDto accountById(Long id);
	
	AccountDto deposit(Long id,double amount);
	
	AccountDto withdraw(Long id,double amount);
}
