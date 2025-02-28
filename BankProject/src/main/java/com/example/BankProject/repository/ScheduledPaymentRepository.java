package com.example.BankProject.repository;


import com.example.BankProject.entity.ScheduledPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduledPaymentRepository extends JpaRepository<ScheduledPayment,Long> {
    List<ScheduledPayment> findByScheduledTimeBeforeAndProcessedFalse(LocalDateTime now);
}
