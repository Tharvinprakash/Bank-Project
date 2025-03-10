package com.example.BankProject.service;

import com.example.BankProject.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto CreateAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id,double amount);

    AccountDto withdraw(Long id,double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

    void transfer(Long senderId,Long receiverId,double amount);
}
