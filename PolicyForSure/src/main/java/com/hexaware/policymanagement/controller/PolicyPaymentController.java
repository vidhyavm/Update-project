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

import com.hexaware.policymanagement.dto.PolicyPaymentDTO;
import com.hexaware.policymanagement.entity.PolicyPayment;
import com.hexaware.policymanagement.services.IPolicyPaymentServices;
/* Author:Devanshu
 * @CreatedOn:-15-11-2023
 * Description: Address Controller Class
 */
/* Author:Devanshu
 * @UpdatedOn:-17-11-2023
 * Description: Assigned Authority
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/policy-payment")
public class PolicyPaymentController 
{
	@Autowired
	IPolicyPaymentServices service;


	@PostMapping(value = "/add",consumes = "application/json",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")

	public PolicyPayment createPolicyPayment(@RequestBody PolicyPaymentDTO policyPaymentDTO)
	{
		return service.createPolicyPayment(policyPaymentDTO);
	}
	
	
	@PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")

	public PolicyPayment updatePolicyPayment(@RequestBody PolicyPaymentDTO policyPaymentDTO)
	{
		return service.updatePolicyPayment(policyPaymentDTO);
	}
	
	
	@DeleteMapping(value = "/delete/{TxnId}",consumes = "application/json")
	@PreAuthorize("hasAuthority('Admin')")

	public void deletePolicyPaymentByTxnId(@PathVariable long txnId)
	{
		service.deletePolicyPaymentByTxnId(txnId);
	}
	
	
	@GetMapping(value = "/getall",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")

	public List<PolicyPayment> getAllPolicyPayment()
	{
		return service.getAllPolicyPayment();
		
	}
	
	
	@GetMapping(value = "/get/policy-no/{policyNo}",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")

	public PolicyPayment getPolicyPaymentByPolicyNo(@PathVariable PolicyPayment policyNo)
	{
		return service.getPolicyPaymentByPolicyNo(policyNo);
		
	}
	
	@GetMapping(value = "/get/txnId/{txnId}",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")

	public PolicyPayment getPolicyPaymentByTxnId(@PathVariable long txnId)
	{
		return service.getPolicyPaymentByTxnId(txnId);
		
	}

}
