package com.hexaware.policymanagement.exception;
/* Author:Devanshu
 * @CreatedOn:-16-11-2023
 * Description: User Defined exception 
 */
public class AddressNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException(String message) 
	{
        super(message);
    }
}