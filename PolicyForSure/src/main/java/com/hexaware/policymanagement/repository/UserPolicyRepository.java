package com.hexaware.policymanagement.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.policymanagement.entity.Policy;
import com.hexaware.policymanagement.entity.User;
import com.hexaware.policymanagement.entity.UserPolicy;

/* Author:Devanshu
 * @CreatedOn:-14-11-2023
 * Description: UserPolicy Repository
 */
@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long>
{	
	@Query("select p from UserPolicy p where p.user =?1 ")
	public List<UserPolicy> getUserPoliciesByUserId(User userId);
	@Query("delete from UserPolicy u where u.policyNo=:policy_no")
	public void deletePolicy(@Param("policy_no") long policyNo);
	
	public boolean existsByUserAndPolicyAndEndDateAfter(User user, Policy policy, LocalDate now);
	
}



