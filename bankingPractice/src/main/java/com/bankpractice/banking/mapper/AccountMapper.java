package com.bankpractice.banking.mapper;

import com.bankpractice.banking.dto.AccountDto;
import com.bankpractice.banking.entity.Account;

public class AccountMapper {
public static Account createAccount(AccountDto accountDto) {
	Account account=new Account(
			accountDto.getId(),
			accountDto.getName(),
			accountDto.getBalance()
			);
	
	return account;
}

public static AccountDto mapToAccountDto(Account account) {
	AccountDto accountDto=new AccountDto(
			account.getId(),
			account.getName(),
			account.getBalance()
			);
 
	return accountDto;
	
}

}
