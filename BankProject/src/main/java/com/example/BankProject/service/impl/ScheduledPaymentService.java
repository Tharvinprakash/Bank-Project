package com.example.BankProject.service.impl;


import com.example.BankProject.dto.ScheduledPaymentDto;

import java.util.List;

public interface ScheduledPaymentService {
    ScheduledPaymentDto schedulePayment(Long senderId,Long receiverId, double amount,String scheduledTime);
    List<ScheduledPaymentDto> getAllScheduledPayments();
}
