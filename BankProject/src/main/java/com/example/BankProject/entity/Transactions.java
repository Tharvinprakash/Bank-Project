package com.example.BankProject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String type;
    private double amount;
    private LocalDateTime timeStamp;

    public Transactions(){

    }

    public Transactions(Account account, String type, double amount, LocalDateTime timeStamp) {
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }


}
