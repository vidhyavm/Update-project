package com.hexaware.policymanagement.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;
/* Author:VidhyaMalathi
 * @CreatedOn:09-11-2023
 * Description: Created User Entity Class 
 */

/* Author:VidhyaMalathi/Devanshu
 * @UpdatedOn:16-11-2023
 * Description: Added Validations/Mappings
 */
@Entity
public class PolicyPayment implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "txn_seq_generator")
    @SequenceGenerator(name = "txn_seq_generator", sequenceName = "txn_seq", allocationSize = 1,initialValue =140000)
	private long txnId;
	
	@NotNull(message = "Payment date cannot be null")
    @PastOrPresent(message = "Payment date must be in the present or past")
    private LocalDate paymentDate;

    @Positive(message = "Amount must be a positive number")
    private double amount;

    @NotEmpty(message = "Bank name cannot be empty")
    @Size(max = 100, message = "Bank name cannot exceed 100 characters")
    private String bank;

    @Pattern(regexp = "^(Pending|Completed)$", message = "Invalid payment status")
    private String paymentStatus;

    @PositiveOrZero(message = "Fine must be a positive or zero number")
    private double fine;
	
    
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "policyNo")
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

	@Override
	public String toString() {
		return "PolicyPayment [txnId=" + txnId + ", paymentDate=" + paymentDate + ", amount=" + amount + ", bank="
				+ bank + ", paymentStatus=" + paymentStatus + ", fine=" + fine + ", userPolicy=" + userPolicy + "]";
	}

	public PolicyPayment(long txnId, LocalDate paymentDate, double amount, String bank, String paymentStatus, double fine,
			UserPolicy userPolicy) {
		super();
		this.txnId = txnId;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.bank = bank;
		this.paymentStatus = paymentStatus;
		this.fine = fine;
		this.userPolicy = userPolicy;
	}

	public PolicyPayment() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}