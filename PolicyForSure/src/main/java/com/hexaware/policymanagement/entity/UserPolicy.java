package com.hexaware.policymanagement.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

/* Author:VidhyaMalathi
 * @CreatedOn:09-11-2023
 * Description: Created User Entity Class 
 */

/* Author:VidhyaMalathi/Devanshu
 * @UpdatedOn:16-11-2023
 * Description: Added Validations/Mappings
 */
@Entity
public class UserPolicy implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userPolicy_seq_generator")
    @SequenceGenerator(name = "userPolicy_seq_generator", sequenceName = "userPolicy_seq", allocationSize = 1, initialValue =110000)
	private long policyNo;
	 
	@NotNull(message = "Start date cannot be null")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null")
    @Future(message = "End date must be in the future")
    private LocalDate endDate;
     
	@ManyToOne
	@JoinColumn(name = "userId",referencedColumnName = "userId")
//	@JsonManagedReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "policyId",referencedColumnName = "policyId")
//	@JsonManagedReference
	private Policy policy;
	
	@JsonBackReference
	@OneToOne(mappedBy = "userPolicy")
	private PolicyPayment policyPayment;
	
	
	
	public long getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(long policyNo) {
		this.policyNo = policyNo;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public PolicyPayment getPolicyPayment() {
		return policyPayment;
	}
	public void setPolicyPayment(PolicyPayment policyPayment) {
		this.policyPayment = policyPayment;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public UserPolicy(long policyNo, LocalDate startDate, User user, Policy policy, PolicyPayment policyPayment,
			 LocalDate endDate) {
		super();
		this.policyNo = policyNo;
		this.startDate = startDate;
		this.user = user;
		this.policy = policy;
		this.policyPayment = policyPayment;
		this.endDate = endDate;
		
	}
	
	
	public UserPolicy() {
		super();
	}
	@Override
	public String toString() {
		return "UserPolicy [policyNo=" + policyNo + ", startDate=" + startDate + ", endDate=" + endDate + ", user="
				+ user + ", policy=" + policy + "]";
	}
	
	
	
	
}