package com.example.BankProject.controller;

import com.example.BankProject.dto.AccountDto;
import com.example.BankProject.dto.TransactionDto;
import com.example.BankProject.service.impl.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable Long id,
                                                                @RequestParam(required = false) String type){
        List<TransactionDto> transactions;
        if (type != null) {
            transactions = transactionService.getTransactionIdAndType(id, type);
        } else {
            transactions = transactionService.getTransactionsById(id);
        }
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{accountId}/paginated")
    public ResponseEntity<Page<TransactionDto>> getTransactions(
            @PathVariable Long accountId, Pageable pageable){
        return ResponseEntity.ok(transactionService.getTransactionsAccountById(accountId,pageable));
    }
}
