package com.cg.account.bean;

import java.time.LocalDateTime;

public class Account {
 public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
public String getName() {
		return name;
	}


	public Account() {
	super();
	// TODO Auto-generated constructor stub
}
	public Account(String name, String phoneNo, double balance, String emailId,
		LocalDateTime date) {
	super();
	this.name = name;
	this.phoneNo = phoneNo;
	this.balance = balance;
	this.emailId = emailId;
	this.date = date;
}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
String name;
 String phoneNo;
 double balance;
 String emailId;
 LocalDateTime date;
 
}
