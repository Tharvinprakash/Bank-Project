package com.example.BankProject.service.impl;


import com.example.BankProject.dto.TransactionDto;
import com.example.BankProject.entity.Transactions;
import com.example.BankProject.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public List<TransactionDto> getTransactionsById(Long id) {
       List<Transactions> transactions = transactionRepository.findByAccountId(id);

       return transactions.stream()
               .map(transaction -> new TransactionDto(
                    transaction.getId(),
                    transaction.getType(),
                       transaction.getAmount(),
                       transaction.getTimeStamp()))
               .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDto> getTransactionIdAndType(Long id, String type) {
        List<Transactions> transactions = transactionRepository.findByAccountIdAndType(id,type);
        return transactions.stream()
                .map(transaction -> new TransactionDto(
                        transaction.getId(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getTimeStamp()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<TransactionDto> getTransactionsAccountById(Long id, Pageable pageable) {
        Page<Transactions> transactionPage = transactionRepository.findByAccountId(id,pageable);
        return transactionPage.map(this::mapToDto);
    }
    private TransactionDto mapToDto(Transactions transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getAccount().getId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getTimeStamp()
                );
    }
}
