package com.transactions.Transactions.service;

import java.io.FileNotFoundException;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactions.Transactions.model.Payment;
import com.transactions.Transactions.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepository paymentRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void pay(Payment payment) throws FileNotFoundException{
		
		this.paymentRepository.save(payment);
		
		log.info("=====> Payment Id:{}", payment.getId());
		
		//throw new FileNotFoundException("Buggg");
	}
}
