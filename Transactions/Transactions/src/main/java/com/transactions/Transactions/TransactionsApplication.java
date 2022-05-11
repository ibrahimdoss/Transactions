package com.transactions.Transactions;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.transactions.Transactions.model.Order;
import com.transactions.Transactions.model.Payment;
import com.transactions.Transactions.service.OrderService;
import com.transactions.Transactions.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner transactionRunner(
		OrderService orderService,
		PaymentService paymentService
			)throws FileNotFoundException {
		
				Payment payment = Payment.builder()
						.userId(1)
						.orderId(2)
						.price(BigDecimal.valueOf(23))
						.build();
				
				Order order = Order.builder()
						.productCode("skills1")
						.amount(3)
						.unitPrice(BigDecimal.valueOf(23.1))
						.userId(23)
						.build();
				
				//paymentService.pay(payment);
				orderService.placeOrder(order);
				
				return null;
		
	}

}
