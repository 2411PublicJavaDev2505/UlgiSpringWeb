package com.spring.ulgi.customer.controller.dto;

public class UpdateRequest {
	private int userNo;
	private String userName;
	private String addr;
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "UpdateRequest [userNo=" + userNo + ", userName=" + userName + ", addr=" + addr + "]";
	}
	
}
