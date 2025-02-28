package com.example.BankProject.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "scheduled_payments")
public class ScheduledPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_account_id", nullable = false)
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id", nullable = false)
    private Account receiver;

    private double amount;
    private LocalDateTime scheduledTime;
    private boolean processed;


    public ScheduledPayment(){

    }

    public ScheduledPayment(Account sender, Account receiver, double amount, LocalDateTime scheduledTime) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.scheduledTime = scheduledTime;
        this.processed = false;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
