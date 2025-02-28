package com.example.BankProject.entity;

import jakarta.persistence.*;

@Table(name = "accounts")
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;
    private double balance;

    @Column(unique=true,nullable=false)
    private String email;

    public Account(){

    }

    public Account(Long id, String accountHolderName, double balance,String email) {
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
