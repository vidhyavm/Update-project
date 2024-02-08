package com.hexaware.policymanagement.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.hexaware.policymanagement.entity.Address;
import com.hexaware.policymanagement.entity.UserPolicy;
/* Author:Vidhyamalathi
 * @CreatedOn:-12-11-2023
 * Description: AddressDTO Class
 */

public class UserDTO 
{

	private long userId;
	private String fname;
	private String lname;
	private String password;
	private String email;
	private String mobNo;
	private String userType;
	private String employerType;
	private String employerName;
	private String panNumber;
	private String userCategory;
	private LocalDate dob;
	private String salary;
	private Address address;
	
	private Set<UserPolicy> userPolicies = new HashSet<>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public Set<UserPolicy> getUserPolicies() {
		return userPolicies;
	}

	public void setUserPolicies(Set<UserPolicy> userPolicies) {
		this.userPolicies = userPolicies;
	}

	public String getEmployerType() {
		return employerType;
	}

	public void setEmployerType(String employerType) {
		this.employerType = employerType;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	

	

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public UserDTO(long userId, String fname, String lname, String password, String email, String mobNo,
			String userType, String employerType, String employerName, String panNumber, String userCategory,
			LocalDate dob, Address address, Set<UserPolicy> userPolicies, String salary) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.email = email;
		this.mobNo = mobNo;
		this.userType = userType;
		this.employerType = employerType;
		this.employerName = employerName;
		this.panNumber = panNumber;
		this.userCategory = userCategory;
		this.dob = dob;
		this.address = address;
		this.userPolicies = userPolicies;
		this.salary = salary;
	}

	public UserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", password=" + password
				+ ", email=" + email + ", mobNo=" + mobNo + ", userType=" + userType + ", employerType=" + employerType
				+ ", employerName=" + employerName + ", panNumber=" + panNumber + ", userCategory=" + userCategory
				+ ", dob=" + dob + ", salary=" + salary + ", address=" + address + "]";
	}

	

	
	
		
		
		
		
		
		
		
		
		
		
		


		
		


}
