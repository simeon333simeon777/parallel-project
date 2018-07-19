package com.cg.paytmwallet.dao;

import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.exception.PaytmWalletException;

public interface PatymWalletDao {
	String createAccount(Account acc) throws PaytmWalletException;
	double showBalance(String mobileNo) throws PaytmWalletException;
	Account deposit(String mobileNo) throws PaytmWalletException;
	Account withdraw(String mobileNo) throws PaytmWalletException;
	Account printTransactionDetails(String mobileNo) throws PaytmWalletException;

}
