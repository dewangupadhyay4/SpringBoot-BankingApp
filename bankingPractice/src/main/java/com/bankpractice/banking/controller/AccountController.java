package com.bankpractice.banking.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankpractice.banking.dto.AccountDto;
import com.bankpractice.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> findbyId(Long id){
		AccountDto accDto=accountService.accountById(id);
		return ResponseEntity.ok(accDto);
	}
	
	@PutMapping("/{id)/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){
		Double amount=request.get("amount");
		AccountDto accountdto=accountService.deposit(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	@DeleteMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> delete(@PathVariable Long id,@RequestBody Map<String,Double> request){
		double amount=request.get("amount");
		AccountDto accountdto=accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountdto);
	}

}
