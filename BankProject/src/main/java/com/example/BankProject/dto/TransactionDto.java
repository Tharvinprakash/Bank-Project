package com.example.BankProject.dto;


import java.time.LocalDateTime;

public class TransactionDto {

    private Long id;
    private Long accountId;
    private String type;
    private double amount;
    private LocalDateTime timestamp;


    public TransactionDto(){

    }

    public TransactionDto(Long id, String type, double amount, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public TransactionDto(Long id, Long accountId, String type, double amount, LocalDateTime timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

