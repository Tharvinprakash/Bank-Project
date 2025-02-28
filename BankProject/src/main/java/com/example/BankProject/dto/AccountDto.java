package com.example.BankProject.dto;

public class AccountDto {

    private Long id;
    private String accountHolderName;
    private double balance;
    private String email;

    public AccountDto(){

    }

    public AccountDto(Long id, String accountHolderName, double balance,String email) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
