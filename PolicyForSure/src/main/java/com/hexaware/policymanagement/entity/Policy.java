package com.hexaware.policymanagement.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
public class Policy implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_seq_generator")
    @SequenceGenerator(name = "policy_seq_generator", sequenceName = "policy_seq", allocationSize = 1,initialValue =100000)
	private long policyId;

    @NotEmpty(message = "Policy name cannot be empty")
    @Size(max = 100, message = "Policy name cannot exceed 100 characters")
    private String policyName;

    @Size(max = 500, message = "Policy description cannot exceed 500 characters")
    private String policyDescription;

    @NotEmpty(message = "Policy type cannot be empty")
    private String policyType;

    @NotEmpty(message = "Company name cannot be empty")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String company;

    @Positive(message = "Amount must be a positive number")
    private double amount;
    
    @NotEmpty
    @Pattern(regexp = "^(Monthly|Quaterly|Half-Yearly|Annually)$")
    private String termPeriod;

    @PositiveOrZero(message = "Maturity amount must be a positive or zero number")
    private double maturityAmount;
    
    @PositiveOrZero(message = "Interest must be a positive or zero number")
    private double interest;
    
    @Positive
    private double termNo;
    
    @OneToMany(mappedBy = "policy",cascade = CascadeType.ALL)
    @JsonBackReference
	private Set<UserPolicy> userPolicies = new HashSet<>();
	
	
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
	public void setAmount(double amount) {
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
	
	public double getTermNo() {
		return termNo;
	}
	public void setTermNo(double termNo) {
		this.termNo = termNo;
	}
	public Policy(long policyId, String policyName, String policyDescription, String policyType, String company,
			 double amount, double maturityAmount,double interest, String termPeriod, Set<UserPolicy> userPolicies,double termNo) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyDescription = policyDescription;
		this.policyType = policyType;
		this.company = company;
		this.amount = amount;
		this.maturityAmount = maturityAmount;
		this.interest = interest;
		this.termPeriod= termPeriod;
		this.userPolicies=userPolicies;
		this.termNo=termNo;
	}
	
	
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyDescription="
				+ policyDescription + ", policyType=" + policyType + ", company=" + company + ", amount=" + amount
				+ ", termPeriod=" + termPeriod + ", maturityAmount=" + maturityAmount + ", interest=" + interest
				+ ", termNo=" + termNo + "]";
	}
	public Policy() {
		super();
	}
	
	public void addUserPolicy(UserPolicy user)
	{
		user.setPolicy(this);
		Set<UserPolicy> set = getUserPolicies() ;
		set.add(user);
	}
	
	
	
	
	
	
	
	
	

}