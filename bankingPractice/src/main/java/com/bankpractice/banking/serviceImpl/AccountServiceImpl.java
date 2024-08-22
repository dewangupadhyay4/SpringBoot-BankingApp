package com.bankpractice.banking.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankpractice.banking.dto.AccountDto;
import com.bankpractice.banking.entity.Account;
import com.bankpractice.banking.mapper.AccountMapper;
import com.bankpractice.banking.repository.AccountRepository;
import com.bankpractice.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.createAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto accountById(Long id) {
		Account acc=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Not available"));
		return AccountMapper.mapToAccountDto(acc);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account acc=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Not available"));
		double total=acc.getBalance()+amount;
		acc.setBalance(total);
		Account saved=accountRepository.save(acc);
		return AccountMapper.mapToAccountDto(saved);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account acc=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Not available"));
		if(acc.getBalance()<amount) {
			throw new RuntimeException("Insufficient Amount"); 
		}
		double total=acc.getBalance()-amount;
		acc.setBalance(total);
		Account saved=accountRepository.save(acc);
		return AccountMapper.mapToAccountDto(saved);
	}



}
