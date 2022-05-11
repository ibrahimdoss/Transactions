package com.transactions.Transactions.model;

import java.beans.Transient;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer userId;
	
	private String productCode;
	
	private Integer amount;
	
	private BigDecimal unitPrice;
	
	@Transient
	public BigDecimal getTotalPrice() {
		return this.unitPrice.multiply(BigDecimal.valueOf(this.amount));
	}

}
