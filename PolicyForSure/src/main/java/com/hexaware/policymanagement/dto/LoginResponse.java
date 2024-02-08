package com.hexaware.policymanagement.dto;

public class LoginResponse
{
	
	private String userId;
	private String userType;
	private String token;
	private String userName;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LoginResponse(String userId, String userType, String token, String userName) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.token = token;
		this.userName= userName;
	}
	public LoginResponse() {
		super();
	}
	@Override
	public String toString() {
		return "LoginResponse [userId=" + userId + ", userType=" + userType + ", token=" + token + "]";
	}
	
	

}
