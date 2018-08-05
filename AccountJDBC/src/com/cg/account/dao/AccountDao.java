package com.cg.account.dao;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;

public interface AccountDao {
	String createNewAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws AccountException;
	Account deposit(String mobileNo, double depositAmt) throws AccountException;
	Account withdraw(String mobileNo, double withdrawAmt) throws AccountException;
	Account printTransactionDetails(String mobileNo) throws AccountException;
	
}
