package com.spring.ulgi.customer.model.vo;

import java.sql.Date;

public class Customer {
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
	private String addr;
	private String gender;
	private Date enrollDate;
	
	public Customer() {}

	public Customer(int userNo, String userId, String userName, int userAge, String addr, String gender,
			Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.addr = addr;
		this.gender = gender;
		this.enrollDate = enrollDate;
	}
	
	

	public Customer(int userNo, String userName, String addr) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.addr = addr;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public String getAddr() {
		return addr;
	}

	public String getGender() {
		return gender;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	@Override
	public String toString() {
		return "Customer [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userAge=" + userAge
				+ ", addr=" + addr + ", gender=" + gender + ", enrollDate=" + enrollDate + "]";
	}

	
	
}