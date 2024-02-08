package com.hexaware.policymanagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagement.dto.PolicyDTO;
import com.hexaware.policymanagement.entity.Policy;
import com.hexaware.policymanagement.services.IPolicyServices;

/* Author:Devanshu
 * @CreatedOn:-15-11-2023
 * Description: Address Controller Class
 */
/* Author:Devanshu/VidhyaMalathi
 * @UpdatedOn:-17-11-2023
 * Description: Assigned Authority
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/policies")
public class PolicyController 
{
	@Autowired
	IPolicyServices service;
	
	@PostMapping(value = "/add",consumes = "application/json",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")
	public Policy addPolicy(@RequestBody PolicyDTO policyDTO)
	{
		System.out.println(policyDTO);
		return service.createPolicy(policyDTO);
	}
	
	
	@PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")
	public Policy updatePolicy(@RequestBody PolicyDTO policyDTO)
	{
		return service.updatePolicy(policyDTO);
	}
	
	
	@DeleteMapping(value = "/delete/{policyId}")
	@PreAuthorize("hasAuthority('Admin')")

	public void deletePolicyById(@PathVariable Long policyId)
	{
		service.deleteByPolicyId(policyId);
	}
	
	@GetMapping(value = "/get/company/{company}",produces = "application/json")
	@PreAuthorize("hasAnyAuthority('Admin','User')")

	public List<Policy> getPolicyByCompany(@PathVariable String company)
	{
		return service.getPolicyByCompany(company);
	}
	
	
	@GetMapping(value = "/getall",produces = "application/json")
	public List<Policy> getAllPolicy()
	{
		return service.getAllPolicy();
		
	}
	
	@GetMapping(value = "/get/policy-type/{policyType}")
	public List<Policy> getPolicyByPolicyType(@PathVariable String policyType)
	{
		return service.getPolicyByPolicyType(policyType);
	}
	
	
	@GetMapping("/get/amountgt/{amount}")
	@PreAuthorize("hasAnyAuthority('Admin','User')")

	public List<Policy> getByAmountGreaterThan(@PathVariable long amount)
	{
		return service.getByAmountGreaterThan(amount);
		
	}
	
	@GetMapping("/get/amountlt/{amount}")
	@PreAuthorize("hasAnyAuthority('Admin','User')")

	public List<Policy> getByAmountLessThan(@PathVariable long amount)
	{
		return service.getByAmountLessThan(amount);
		
	}	
	
	
	
	
}
