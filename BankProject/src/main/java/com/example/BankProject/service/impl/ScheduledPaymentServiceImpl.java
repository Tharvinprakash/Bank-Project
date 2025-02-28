package com.example.BankProject.service.impl;


import com.example.BankProject.dto.ScheduledPaymentDto;
import com.example.BankProject.entity.Account;
import com.example.BankProject.entity.ScheduledPayment;
import com.example.BankProject.repository.AccountRepository;
import com.example.BankProject.repository.ScheduledPaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class ScheduledPaymentServiceImpl implements ScheduledPaymentService {

    private final ScheduledPaymentRepository scheduledPaymentRepository;
    private final AccountRepository accountRepository;

    public ScheduledPaymentServiceImpl(ScheduledPaymentRepository scheduledPaymentRepository, AccountRepository accountRepository) {
        this.scheduledPaymentRepository = scheduledPaymentRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public ScheduledPaymentDto schedulePayment(Long senderId, Long receiverId, double amount, String scheduledTime) {
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender account Not found"));
        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver account Not found"));


        LocalDateTime time = LocalDateTime.parse(scheduledTime,DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Save Scheduled Payment
        ScheduledPayment scheduledPayment = new ScheduledPayment(sender, receiver, amount, time);
        scheduledPaymentRepository.save(scheduledPayment);

        return new ScheduledPaymentDto(scheduledPayment.getId(), senderId, receiverId, amount, scheduledPayment.getScheduledTime());
    }


    @Override
    public List<ScheduledPaymentDto> getAllScheduledPayments() {
        return scheduledPaymentRepository.findAll().stream()
                .map(payment -> new ScheduledPaymentDto(payment.getId(), payment.getSender().getId(),
                        payment.getReceiver().getId(), payment.getAmount(), payment.getScheduledTime()))
                .collect(Collectors.toList());

    }
}

