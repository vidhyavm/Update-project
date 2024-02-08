package com.hexaware.policymanagement.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/* Author:VidhyaMalathi
 * @CreatedOn:09-11-2023
 * Description: Created User Entity Class 
 */

/* Author:VidhyaMalathi/Devanshu
 * @UpdatedOn:16-11-2023
 * Description: Added Validations/Mappings
 */

@Entity
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
	    @SequenceGenerator(name = "user_seq_generator", sequenceName = "user_seq", allocationSize = 1,initialValue =120000)
		private long userId;
		
		
		@NotEmpty(message = "First name cannot be empty")
	    @Size(max = 50, message = "First name cannot exceed 50 characters")
	    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "First name can only contain letters and spaces")
	    private String fname;

	    @NotEmpty(message = "Last name cannot be empty")
	    @Size(max = 50, message = "Last name cannot exceed 50 characters")
	    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Last name can only contain letters and spaces")
	    private String lname;

	    
//	    @Pattern(
//	            regexp = "^[a-zA-Z0-9]{8,}$",
//	            message = "Password must be at least 8 characters long and contain only alphanumeric characters."
//	        )
	    private String password;
	    
	    @Positive
	    private String salary;

	    @Email(message = "Invalid email format")
	    private String email;

	    @Pattern(regexp = "^[6789]\\d{9}$", message = "Invalid Indian mobile number")
	    private String mobNo;

	    @Pattern(regexp = "^(Admin|User)$", message = "User type must be 'Admin' or 'User'")
	    private String userType;
	    
	    @NotEmpty(message = "Employer type cannot be empty")
	    @Pattern(regexp = "^(Salaried|Optional)$", message = "Invalid employer type")
	    private String employerType;

	    @NotEmpty(message = "Employer name cannot be empty if Salaried or Optional")
	    @Size(max = 100, message = "Employer name cannot exceed 100 characters")
	    private String employerName;

	    @NotEmpty( message = "Invalid user category")
	    private String userCategory;

	    @Past(message = "Date of birth must be in the past")
	    private LocalDate dob;
	    
//	    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN number")
	    private String panNumber;
		
	    @JsonManagedReference
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "addressId",referencedColumnName = "addressId")
		private Address address;
		
	    
		@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
		@JsonBackReference
		private Set<UserPolicy> userPolicies = new HashSet<>();
		
		
		
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
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
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public LocalDate getDob() {
			return dob;
		}
		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		
		public String getPanNumber() {
			return panNumber;
		}
		public void setPanNumber(String panNumber) {
			this.panNumber = panNumber;
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
		public User(long userId, String fname, String lname, String password, String email, String mobNo, String userType, String employerType, String employerName,
				String userCategory, Address address, LocalDate dob, String panNumber, Set<UserPolicy> userPolicies, String salary) {
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
			this.userCategory = userCategory;
			this.address = address;
			this.dob = dob;
			this.panNumber = panNumber;
			this.userPolicies = userPolicies;
			this.salary = salary;
		}
		
		
		
		@Override
		public String toString() {
			return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", password=" + password
					+ ", salary=" + salary + ", email=" + email + ", mobNo=" + mobNo + ", userType=" + userType
					+ ", employerType=" + employerType + ", employerName=" + employerName + ", userCategory="
					+ userCategory + ", dob=" + dob + ", panNumber=" + panNumber + ", address=" + address + "]";
		}


		public User() {
			super();
		}
		
		
		
		
		
		
		
		
		


		
		


}
