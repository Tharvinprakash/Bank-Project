package com.example.BankProject.scheduler;


import com.example.BankProject.entity.ScheduledPayment;
import com.example.BankProject.repository.ScheduledPaymentRepository;
import com.example.BankProject.service.AccountService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ScheduledPaymentProcessor {

    private final ScheduledPaymentRepository scheduledPaymentRepository;
    private final AccountService accountService;

    public ScheduledPaymentProcessor(ScheduledPaymentRepository scheduledPaymentRepository, AccountService accountService) {
        this.scheduledPaymentRepository = scheduledPaymentRepository;
        this.accountService = accountService;
    }

    @Scheduled(fixedRate = 60000)
    public void processScheduledPayments(){
        List<ScheduledPayment> pendingPayments = scheduledPaymentRepository.findByScheduledTimeBeforeAndProcessedFalse(LocalDateTime.now());

        for(ScheduledPayment payment : pendingPayments){
            try{
                accountService.transfer(payment.getSender().getId(), payment.getReceiver().getId(), payment.getAmount());
                payment.setProcessed(true);
                scheduledPaymentRepository.save(payment);
                System.out.println("✅ Scheduled Payment Processed: " + payment.getId());
            }
            catch(Exception e){
                System.out.println("❌ Failed to process scheduled payment: " + payment.getId());
            }
        }
    }
}
