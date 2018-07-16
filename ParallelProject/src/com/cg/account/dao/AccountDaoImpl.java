package com.cg.account.dao;

import java.util.HashMap;

import com.cg.account.bean.Account;
import com.cg.account.db.AccountDb;
import com.cg.account.exception.AccountException;

public class AccountDaoImpl implements AccountDao {
private static HashMap<String,Account>accMap=AccountDb.getAccDb();
	@Override
	public String createNewAccount(Account acc) throws AccountException {
		accMap.put(acc.getPhoneNo(), acc);
		return acc.getPhoneNo();
	}
	@Override
	public double showBalance(String mobileNo) throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (acc == null) {
		throw new AccountException("The mobile number does not exist");
		}
		return acc.getBalance();
	}
	@Override
	public Account deposit(String mobileNo) throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (acc == null) {
		throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}
	@Override
	public Account withdraw(String mobileNo) throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (acc == null) {
		throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}
	@Override
	public Account printTransactionDetails(String mobileNo)
			throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (acc == null) {
		throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}

	

}
