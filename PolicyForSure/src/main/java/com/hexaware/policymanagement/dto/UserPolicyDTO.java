package com.hexaware.policymanagement.dto;

import java.time.LocalDate;

/* Author:Vidhyamalathi
 * @CreatedOn:-12-11-2023
 * Description: AddressDTO Class
 */
public class UserPolicyDTO 
{
	private long policyNo;
	private LocalDate startDate;
	private LocalDate endDate;
	private long userId;
	private long policyId;
	private long txnId;
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
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPolicyId() {
		return policyId;
	}
	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}
	public long getTxnId() {
		return txnId;
	}
	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}
	public UserPolicyDTO(long policyNo, LocalDate startDate, LocalDate endDate, long userId, long policyId,
			long txnId) {
		super();
		this.policyNo = policyNo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
		this.policyId = policyId;
		this.txnId = txnId;
	}
	@Override
	public String toString() {
		return "UserPolicyDTO [policyNo=" + policyNo + ", startDate=" + startDate + ", endDate=" + endDate + ", userId="
				+ userId + ", policyId=" + policyId + ", txnId=" + txnId + "]";
	}
	public UserPolicyDTO() {
		super();
	}
	
	
	
	
	
	
	
	

	
	




	

}