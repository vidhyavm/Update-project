package com.hexaware.policymanagement.exception;
/* Author:Devanshu
 * @CreatedOn:-17-11-2023
 * Description: User Defined exception 
 */
public class PolicyNotFoundException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public PolicyNotFoundException(String message) 
	{
        super(message);
    }
}
