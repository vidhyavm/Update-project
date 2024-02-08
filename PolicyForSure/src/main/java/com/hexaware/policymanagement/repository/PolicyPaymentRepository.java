package com.hexaware.policymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: PolicyPayment Repository
 */
import org.springframework.stereotype.Repository;

import com.hexaware.policymanagement.entity.PolicyPayment;
@Repository
public interface PolicyPaymentRepository extends JpaRepository<PolicyPayment, Long> 
{
	
	public PolicyPayment findByUserPolicy(PolicyPayment policyNo);
	


}
