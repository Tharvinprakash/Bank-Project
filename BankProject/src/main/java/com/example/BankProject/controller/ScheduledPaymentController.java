package com.example.BankProject.controller;

import com.example.BankProject.dto.ScheduledPaymentDto;
import com.example.BankProject.service.impl.ScheduledPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduled-payments")
public class ScheduledPaymentController {

    private final ScheduledPaymentService scheduledPaymentService;

    public ScheduledPaymentController(ScheduledPaymentService scheduledPaymentService) {
        this.scheduledPaymentService = scheduledPaymentService;
    }

    @PostMapping
    public ResponseEntity<ScheduledPaymentDto> schedulePayment(@RequestBody ScheduledPaymentDto request) {
        ScheduledPaymentDto scheduledPayment = scheduledPaymentService.schedulePayment(
                request.getSenderId(),
                request.getReceiverId(),
                request.getAmount(),
                request.getScheduledTime().toString()
        );
        return ResponseEntity.ok(scheduledPayment);
    }

    @GetMapping
    public ResponseEntity<List<ScheduledPaymentDto>> getAllScheduledPayments() {
        return ResponseEntity.ok(scheduledPaymentService.getAllScheduledPayments());
    }
}
