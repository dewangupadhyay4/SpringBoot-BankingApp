package com.bankpractice.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankpractice.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
