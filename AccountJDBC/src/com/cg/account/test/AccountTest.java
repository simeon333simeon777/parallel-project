package com.cg.account.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;
import com.cg.account.service.AccountServiceImpl;
import com.cg.account.service.AccountService;



public class AccountTest {


	private AccountService service;

	@Before

	public void init() {
		service = new AccountServiceImpl();
	}

  
	@Test
	public void testCreateNewAccountForName() {
	Account acc = new Account();
	acc.setPhoneNo("1234567899");
	acc.setName("raju");
	acc.setEmailId("raju@gmail.com");
	acc.setBalance(100.0);
	try {
	service.createNewAccount(acc);
	} catch (AccountException e) {
	assertEquals("Name should start with capital letter with minimum 3 characters and should contain only alphabets", e.getMessage());
	}
	}
	
	
	@Test
	public void testCreateNewAccountForNameIsEmpty() {
	Account acc = new Account();
	acc.setPhoneNo("1234567899");
	acc.setName("");
	acc.setEmailId("raju@gmail.com");
	acc.setBalance(200.0);
	try {
	service.createNewAccount(acc);
	} catch (AccountException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}	
	
	
	@Test
	public void testCreateNewAccount() {
	Account acc = new Account();
	acc.setPhoneNo("1234567890");
	acc.setName("Raju kumar");
	acc.setEmailId("Raju@gmail.com");
	acc.setBalance(200.0);
	 
	try {
	String s=service.createNewAccount(acc);
	assertNotNull(s);
	} catch (AccountException e) {
	
	 
	}
	 
	}	
	
	@Test
	public void testShowBalanceForMobileNo() {
	
	try {
	service.showBalance("36521");
	} catch (AccountException e) {
	
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}	
	
	
	@Test
	public void testDepositForMobileNo() {
	Account acc=new Account();
	acc.setPhoneNo("95059345");
	try {
	service.deposit(acc.getPhoneNo(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testDepositForDepositAmt1() {
	Account acc=new Account();
	acc.setPhoneNo("9912365478");
	try {
	service.deposit(acc.getPhoneNo(), -230);
	} catch (AccountException e) {
	assertEquals("Deposit amount must be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testDeposit() {
		Account acc=new Account();
		acc.setPhoneNo("8974563215");
		try {
			Account ac1=service.deposit(acc.getPhoneNo(), 230);
			assertNotNull(ac1);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			}
	}	
	
	@Test
	public void testWithDrawForMobileNo() {
	Account acc=new Account();
	acc.setPhoneNo("95059345");
	try {
	service.withdraw(acc.getPhoneNo(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		Account acc=new Account();
		acc.setPhoneNo("9505934512");
		try {
			service.withdraw(acc.getPhoneNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	
	

	
	
	
	@Test
	public void testWithdrawForAmt() {
		Account ac=new Account();
		ac.setPhoneNo("9912365478");
		try {
			service.withdraw(ac.getPhoneNo(), -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}
	
	/*@Test
	public void testWithdrawForMobileNoThatExist() {
	Account acc=new Account();
	acc.setPhoneNo("8974563215");
	try {
	service.withdraw(acc.getPhoneNo(), 230);
	} catch (AccountException e) {
		assertEquals("The mobile number does not exist",e.getMessage());
	}
	}*/
	
	
	@Test
	public void testFundTransferForMobileNo() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setPhoneNo("9912365478");
		ac2.setPhoneNo("1234");
		try {
			service.fundTransfer(ac.getPhoneNo(),ac2.getPhoneNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testFundTransferForMobileNo1() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setPhoneNo("1234");
		ac2.setPhoneNo("9912365478");
		try {
			service.fundTransfer(ac.getPhoneNo(),ac2.getPhoneNo(), 230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	
	
	
	@Test

	public void testFundTransferForMobileNoDoesNotExist() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setPhoneNo("8563214456");
		ac2.setPhoneNo("7896541232");
		try {
			service.fundTransfer(ac.getPhoneNo(), ac2.getPhoneNo(),  230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			assertNotEquals("The mobile number does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForNegativeAmt() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setPhoneNo("9978456321");
		ac2.setPhoneNo("9912365478");
		try {
			service.fundTransfer(ac.getPhoneNo(), ac2.getPhoneNo(),  -230);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
		assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransfer() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setPhoneNo("9505928555");
		ac2.setPhoneNo("9848468242");
		try {
			assertTrue(service.fundTransfer(ac.getPhoneNo(), ac2.getPhoneNo(),  230));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testPrinttransactionDetails() {
		Account ac=new Account();
		ac.setPhoneNo("8974563215");
		try {
			Account acc=service.printTransactionDetails(ac.getPhoneNo());
			assertNotNull(acc);
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/*@Test
	public void testPrinttransactionDetailsForMobileNoDoesNotExist() {
	Account acc=new Account();
	acc.setPhoneNo("8563214456");
	try {
	Account acc1=service.printTransactionDetails(acc.getPhoneNo());
	assertNotNull(acc1);
	} catch (AccountException e) {
		assertEquals("The mobile number does not exist",e.getMessage());
	}
	 
	}*/
	
	
	@Test
	public void testPrinttransactionDetailsForMobileNo() {
	Account acc=new Account();
	acc.setPhoneNo("125463");
	try {
	Account acc1=service.printTransactionDetails(acc.getPhoneNo());
	assertNotNull(acc1);
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	 
	}

}
