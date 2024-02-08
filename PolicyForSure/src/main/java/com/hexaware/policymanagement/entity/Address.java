package com.hexaware.policymanagement.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/* Author:VidhyaMalathi
 * @CreatedOn:09-11-2023
 * Description: Created User Entity Class 
 */

/* Author:VidhyaMalathi/Devanshu
 * @UpdatedOn:16-11-2023
 * Description: Added Validations/Mappings 
 */
@Entity
public class Address implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_generator")
    @SequenceGenerator(name = "address_seq_generator", sequenceName = "address_seq", allocationSize = 1, initialValue =130000)
   	private long addressId;
	@NotEmpty(message = "City cannot be empty")
    @Size(max = 50, message = "City cannot exceed 50 characters")
    private String city;

    @NotEmpty(message = "Address line cannot be empty")
    @Size(max = 255, message = "Address line cannot exceed 255 characters")
    private String addressLine;

    @NotEmpty(message = "State cannot be empty")
    @Size(max = 50, message = "State cannot exceed 50 characters")
    private String state;

    @Positive(message = "Pincode must be a positive number")
    @Digits(integer = 6, fraction = 0, message = "Invalid pincode format")
    private int pincode;
	
    @JsonBackReference
	@OneToOne(mappedBy = "address")
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
	
	


	public Address(long addressId, String city, String addressLine, String state, int pincode, User user) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.addressLine = addressLine;
		this.state = state;
		this.pincode = pincode;
		this.user = user;
	}


	


	


	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", addressLine=" + addressLine + ", state="
				+ state + ", pincode=" + pincode + "]";
	}


	public Address() {
		super();
	}


	


	
	
	
	
	
	

	



	
	
	
	
	
	

}
