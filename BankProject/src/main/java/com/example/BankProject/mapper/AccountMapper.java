package com.example.BankProject.mapper;

import com.example.BankProject.dto.AccountDto;
import com.example.BankProject.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
          accountDto.getId(),
          accountDto.getAccountHolderName(),
          accountDto.getBalance(),
          accountDto.getEmail()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
          account.getId(),
          account.getAccountHolderName(),
          account.getBalance(),
          account.getEmail()
        );
        return accountDto;
    }
}
