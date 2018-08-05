package com.cg.account.bean;

import java.sql.Date;

public class Account {
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	private String name;
	private String phoneNo; 
	private String emailId;
    private double balance;
    Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Account(String name, String phoneNo, String emailId, double balance,
			Date date) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.balance = balance;
		this.date = date;
	}
	public Account() {
		super();
		
	}
}	
		
	
	
	
	

