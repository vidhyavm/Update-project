package com.hexaware.policymanagement.dto;

import java.util.HashSet;
import java.util.Set;

import com.hexaware.policymanagement.entity.UserPolicy;

/* Author:Vidhyamalathi
 * @CreatedOn:-12-11-2023
 * Description: AddressDTO Class
 */
public class PolicyDTO 
{
	private long policyId;
	private String policyName;
	private String policyDescription;
	private String policyType;
	private String company;
	private String termPeriod;
	private double amount;
	private double maturityAmount;
	private double interest;
	private double termNo;
	private Set<UserPolicy> userPolicies = new HashSet<>();

	
	

	public double getTermNo() {
		return termNo;
	}

	public void setTermNo(double termNo) {
		this.termNo = termNo;
	}

	public String getTermPeriod() {
		return termPeriod;
	}

	public void setTermPeriod(String termPeriod) {
		this.termPeriod = termPeriod;
	}

	public long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyDescription() {
		return policyDescription;
	}

	public void setPolicyDescription(String policyDescription) {
		this.policyDescription = policyDescription;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public double getMaturityAmount() {
		return maturityAmount;
	}

	public void setMaturityAmount(double maturityAmount) {
		this.maturityAmount = maturityAmount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Set<UserPolicy> getUserPolicies() {
		return userPolicies;
	}

	public void setUserPolicies(Set<UserPolicy> userPolicies) {
		this.userPolicies = userPolicies;
	}

	

	public PolicyDTO(long policyId, String policyName, String policyDescription, String policyType, String company,
			String termPeriod, double amount, double maturityAmount, double interest, Set<UserPolicy> userPolicies, double termNo) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDescription = policyDescription;
		this.policyType = policyType;
		this.company = company;
		this.termPeriod = termPeriod;
		this.amount = amount;
		this.maturityAmount = maturityAmount;
		this.interest = interest;
		this.userPolicies = userPolicies;
		this.termNo = termNo;
	}

	public PolicyDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PolicyDTO [policyId=" + policyId + ", policyName=" + policyName + ", policyDescription="
				+ policyDescription + ", policyType=" + policyType + ", company=" + company + ", termPeriod="
				+ termPeriod + ", amount=" + amount + ", maturityAmount=" + maturityAmount + ", interest=" + interest
				+ ", termNo=" + termNo + "]";
	}

	

	
	
	
	
	
	
	
	
	
	

}