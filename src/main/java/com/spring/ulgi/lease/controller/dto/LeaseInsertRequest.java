package com.spring.ulgi.lease.controller.dto;

public class LeaseInsertRequest {
	
	private int bookNo;
	private String userId;
	
	public LeaseInsertRequest(int bookNo, String userId) {
		super();
		this.bookNo = bookNo;
		this.userId = userId;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "LeaseInsertRequest [bookNo=" + bookNo + ", userId=" + userId + "]";
	}
	
	
}
