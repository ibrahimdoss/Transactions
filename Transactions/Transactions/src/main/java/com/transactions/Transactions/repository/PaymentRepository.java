package com.transactions.Transactions.repository;

import org.springframework.data.repository.CrudRepository;

import com.transactions.Transactions.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
