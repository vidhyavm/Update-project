package com.hexaware.policymanagement.services;

import java.util.List;

import com.hexaware.policymanagement.dto.UserPolicyDTO;
import com.hexaware.policymanagement.entity.User;
import com.hexaware.policymanagement.entity.UserPolicy;
/* Author:Devanshu/Vidhyamalathi
 * @CreatedOn:-14-11-2023
 * Description: UserPolicy Service Interface
 */
public interface IUserPolicyServices 
{
	public UserPolicy createUserPolicy(UserPolicyDTO userpolicyDTO);
	public UserPolicy updateUserPolicy(UserPolicyDTO userpolicyDTO);
	public void deleteUserPolicyByPolicyNo(long policyNo);
	public UserPolicy getUserPolicyByPolicyNo(long policyNo);
	public List<UserPolicy> getUserPolicyByUserId( User userId);

	public List<UserPolicy> getAllUserPolicy();

}
