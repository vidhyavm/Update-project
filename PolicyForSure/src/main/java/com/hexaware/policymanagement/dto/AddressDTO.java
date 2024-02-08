package com.hexaware.policymanagement.dto;

import com.hexaware.policymanagement.entity.User;
/* Author:Vidhyamalathi
 * @CreatedOn:-12-11-2023
 * Description: AddressDTO Class
 */
public class AddressDTO 
{
	private long addressId;
	private String city;
	private String addressLine;
	private String state;
	private int pincode;
	private User user;


	public long getAddressId() {
		return addressId;
	}


	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddressLine() {
		return addressLine;
	}


	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", city=" + city + ", addressLine=" + addressLine + ", state="
				+ state + ", pincode=" + pincode + "]";
	}


	public AddressDTO(long addressId, String city, String addressLine, String state, int pincode, User user) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.addressLine = addressLine;
		this.state = state;
		this.pincode = pincode;
		this.user = user;
	}


	public AddressDTO() {
		super();
	}
	
	
	
	
	
	
	

	



	
	
	
	
	
	

}
