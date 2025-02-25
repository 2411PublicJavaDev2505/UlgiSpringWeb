package com.spring.ulgi.customer.controller.dto;

public class InsertRequest {
	private String userId;
	private String userName;
	private int userAge;
	private String addr;
	private String gender;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "InsertRequest [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", addr=" + addr
				+ ", gender=" + gender + "]";
	}
	
}
