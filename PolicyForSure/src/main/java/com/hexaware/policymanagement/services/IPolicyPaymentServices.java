package com.hexaware.policymanagement.services;

import java.util.List;

import com.hexaware.policymanagement.dto.PolicyPaymentDTO;
import com.hexaware.policymanagement.entity.PolicyPayment;
/* Author:Devanshu/Vidhyamalathi
 * @CreatedOn:-14-11-2023
 * Description: PolicyPayment Service Interface
 */
public interface IPolicyPaymentServices 
{
	public PolicyPayment createPolicyPayment(PolicyPaymentDTO policyPaymentDTO);
	public PolicyPayment updatePolicyPayment(PolicyPaymentDTO policyPaymentDTO);
	public void deletePolicyPaymentByTxnId(long txnId);
	public PolicyPayment getPolicyPaymentByTxnId(long txnId);
    public PolicyPayment getPolicyPaymentByPolicyNo(PolicyPayment policyNo);


	
	public List<PolicyPayment> getAllPolicyPayment();

}
