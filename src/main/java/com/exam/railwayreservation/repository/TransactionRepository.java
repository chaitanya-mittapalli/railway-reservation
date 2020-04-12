package com.exam.railwayreservation.repository;

import com.exam.railwayreservation.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findAll();
}
