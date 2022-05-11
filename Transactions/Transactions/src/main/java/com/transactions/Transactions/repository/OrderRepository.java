package com.transactions.Transactions.repository;

import org.springframework.data.repository.CrudRepository;

import com.transactions.Transactions.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
