package com.hexaware.policymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.policymanagement.entity.Policy;
/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: Policy Repository
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> 
{

	public List<Policy> findByPolicyType(String policyType);
	
	public List<Policy> findByCompany(String company);
	
	public List<Policy> findByAmountGreaterThan(double amount);
	
	public List<Policy> findByAmountLessThan(double amount); 
	
	@Query("select u from Policy u where u.policyId =?1")
	public Policy findByPolicyId(long policyId);

}
