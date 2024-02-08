package com.hexaware.policymanagement.exception;
/* Author:Devanshu
 * @CreatedOn:-16-11-2023
 * Description: User Defined exception 
 */
public class UserNotFoundException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) 
    {
        super(message);
    }
}
