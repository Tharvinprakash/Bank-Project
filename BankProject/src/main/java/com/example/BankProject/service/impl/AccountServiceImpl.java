package com.example.BankProject.service.impl;

import com.example.BankProject.dto.AccountDto;
import com.example.BankProject.entity.Account;
import com.example.BankProject.entity.Transactions;
import com.example.BankProject.mapper.AccountMapper;
import com.example.BankProject.repository.AccountRepository;
import com.example.BankProject.repository.TransactionRepository;
import com.example.BankProject.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final EmailService emailService;

    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository, EmailService emailService) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.emailService = emailService;
    }

    @Override
    public AccountDto CreateAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount  = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account  = accountRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account  = accountRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        Transactions transaction = new Transactions();
        transaction.setAccount(account);
        transaction.setType("DEPOSIT");
        transaction.setAmount(amount);
        transaction.setTimeStamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        String email = account.getEmail();
        String subject = "DEPOSIT SUCCESSFUL!";
        String message = "Hi! " + account.getAccountHolderName() + " ,<br><br>"
                            + "Your deposit of ₹ " + amount + " was successful. <br>"
                            + "Your new balance is ₹ " + total +  "<br><br>"
                            + "Thanks, <br> Bank Team";

        emailService.sendEmail(email,subject,message);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account  = accountRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Account does not exists"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient Amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        Transactions transaction = new Transactions();
        transaction.setAccount(account);
        transaction.setType("WITHDRAW");
        transaction.setAmount(amount);
        transaction.setTimeStamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        String email = account.getEmail();
        String subject = "Withdrawal Successful!";
        String message = "Hi " + account.getAccountHolderName() + ",<br><br>"
                + "Your withdrawal of ₹ " + amount + " was successful.<br>"
                + "Your new balance is ₹ " + total + ".<br><br>"
                + "Thanks, <br>Bank Team";

        emailService.sendEmail(email, subject, message);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account  = accountRepository
                .findById(id).
                orElseThrow(() -> new RuntimeException("Account does not exists"));
        accountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void transfer(Long senderId, Long receiverId, double amount) {
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(()->new RuntimeException("Sender Not Found"));
        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(()->new RuntimeException("receiver Not Found"));

        if(sender.getBalance() < amount){
            throw new RuntimeException("Insufficient Funds");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transactions senderTransaction = new Transactions(sender,"TRANSFER_SENT",amount,LocalDateTime.now());
        Transactions receiverTransaction = new Transactions(receiver,"TRANSFER_RECEIVED",amount,LocalDateTime.now());

        transactionRepository.save(senderTransaction);
        transactionRepository.save(receiverTransaction);

        String senderEmail = sender.getEmail();
        String senderMessage = "Hi " + sender.getAccountHolderName() + ",<br><br>"
                + "You have transferred ₹" + amount + " to " + receiver.getAccountHolderName() + ".<br>"
                + "Your new balance is ₹ " + sender.getBalance() + ".<br><br>"
                + "Thanks, <br>Bank Team";

        emailService.sendEmail(senderEmail, "Transfer Successful!", senderMessage);

        String receiverEmail = receiver.getEmail();
        String receiverMessage = "Hi " + receiver.getAccountHolderName() + ",<br><br>"
                + "You have received ₹" + amount + " from " + sender.getAccountHolderName() + ".<br>"
                + "Your new balance is ₹" + receiver.getBalance() + ".<br><br>"
                + "Thanks, <br>Bank Team";

        emailService.sendEmail(receiverEmail, "Amount Received!", receiverMessage);

    }


}
