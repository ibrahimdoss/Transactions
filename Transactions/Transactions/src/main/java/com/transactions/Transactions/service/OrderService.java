package com.transactions.Transactions.service;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactions.Transactions.model.Order;
import com.transactions.Transactions.model.Payment;
import com.transactions.Transactions.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

	private final PaymentService paymentService;
	private final OrderRepository orderRepository;
	
	@Transactional(propagation = Propagation.REQUIRED /*rollbackFor = FileNotFoundException.class*/)
	public void placeOrder(Order order) throws FileNotFoundException{
		this.orderRepository.save(order);
		
		log.info("=====> Order Id: {}", order.getId());
		
		Payment payment = Payment.builder()
				.price(order.getTotalPrice())
				.orderId(order.getId())
				.userId(order.getUserId())
				.build();
		this.paymentService.pay(payment);
	}
	
	
}
