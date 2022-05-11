package com.transactions.Transactions.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer userId;
	
	private Integer orderId;
	
	private BigDecimal price;

}
