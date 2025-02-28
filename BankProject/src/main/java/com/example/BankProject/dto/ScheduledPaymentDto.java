package com.example.BankProject.dto;


import java.time.LocalDateTime;

public class ScheduledPaymentDto {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private double amount;
    private LocalDateTime scheduledTime;

    public ScheduledPaymentDto() {
    }

    public ScheduledPaymentDto(Long id, Long senderId, Long receiverId, double amount, LocalDateTime scheduledTime) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.scheduledTime = scheduledTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
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

    @Override
    public String toString() {
        return "ScheduledPaymentDto{" +
                "id=" + id +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", amount=" + amount +
                ", scheduledTime=" + scheduledTime +
                '}';
    }
}
