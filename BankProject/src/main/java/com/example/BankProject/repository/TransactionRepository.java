package com.example.BankProject.repository;


import com.example.BankProject.entity.Transactions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions,Long> {

    List<Transactions> findByAccountIdAndType(Long id,String type);

    List<Transactions> findByAccountId(Long id);

    Page<Transactions> findByAccountId(Long id, Pageable pageable);
}
