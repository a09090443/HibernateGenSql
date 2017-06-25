package com.localhost.model;
// Generated 2017/6/17 下午 08:56:49 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PaymentAmount generated by hbm2java
 */
@Entity
@Table(name = "payment_amount", catalog = "dev_data")
public class PaymentAmount implements java.io.Serializable {

	private String paymentAmountId;
	private Integer amount;
	private String unit;

	public PaymentAmount() {
	}

	public PaymentAmount(String paymentAmountId) {
		this.paymentAmountId = paymentAmountId;
	}

	public PaymentAmount(String paymentAmountId, Integer amount, String unit) {
		this.paymentAmountId = paymentAmountId;
		this.amount = amount;
		this.unit = unit;
	}

	@Id

	@Column(name = "payment_amount_id", unique = true, nullable = false, length = 2)
	public String getPaymentAmountId() {
		return this.paymentAmountId;
	}

	public void setPaymentAmountId(String paymentAmountId) {
		this.paymentAmountId = paymentAmountId;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "unit", length = 2)
	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
