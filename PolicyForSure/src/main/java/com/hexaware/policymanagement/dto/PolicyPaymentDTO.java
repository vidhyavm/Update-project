package com.hexaware.policymanagement.dto;

import java.time.LocalDate;

import com.hexaware.policymanagement.entity.UserPolicy;
/* Author:Vidhyamalathi
 * @CreatedOn:-12-11-2023
 * Description: AddressDTO Class
 */
public class PolicyPaymentDTO 
{
	private long txnId;
	private LocalDate paymentDate;
	private double amount;
	private String bank;
	private String paymentStatus;
	private double fine;
	
	private UserPolicy userPolicy;

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public UserPolicy getUserPolicy() {
		return userPolicy;
	}

	public void setUserPolicy(UserPolicy userPolicy) {
		this.userPolicy = userPolicy;
	}

	public PolicyPaymentDTO(long txnId, LocalDate paymentDate, double amount, String bank, String paymentStatus,
			double fine, UserPolicy userPolicy) {
		super();
		this.txnId = txnId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.bank = bank;
		this.paymentStatus = paymentStatus;
		this.fine = fine;
		this.userPolicy = userPolicy;
	}

	public PolicyPaymentDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PolicyPaymentDTO [txnId=" + txnId + ", paymentDate=" + paymentDate + ", amount=" + amount + ", bank="
				+ bank + ", paymentStatus=" + paymentStatus + ", fine=" + fine + ", userPolicy=" + userPolicy + "]";
	}
	
	
	
	
	
	
	
	
}