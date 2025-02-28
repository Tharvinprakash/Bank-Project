package com.example.BankProject.service.impl;


import com.example.BankProject.dto.TransactionDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TransactionService {

    List<TransactionDto> getTransactionsById(Long id);
    List<TransactionDto> getTransactionIdAndType(Long id,String type);

    Page<TransactionDto> getTransactionsAccountById(Long id, Pageable pageable);


}
