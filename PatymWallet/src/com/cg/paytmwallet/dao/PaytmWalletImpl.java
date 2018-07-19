package com.cg.paytmwallet.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import com.cg.paytmwallet.db.PaytmWalletDb;
import com.cg.paytmwallet.exception.PaytmWalletException;
import com.cg.paytmwallet.bean.Account;

public class PaytmWalletImpl implements PatymWalletDao {
	private static HashMap<String, Account> paytmWalletMap = PaytmWalletDb.getPaytmWalletMap();

	@Override
	public String createAccount(Account acc) throws PaytmWalletException {
		// TODO Auto-generated method stub
		paytmWalletMap.put(acc.getMobileNo(), acc);
		return acc.getMobileNo();
	}

	@Override
	public double showBalance(String mobileNo) throws PaytmWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a == null) {
		throw new PaytmWalletException("The mobile number does not exist");
		}
		return a.getBalance();
		}

	@Override
	public Account deposit(String mobileNo) throws PaytmWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a == null) {
		throw new PaytmWalletException("The mobile number does not exist");
		}
		return a;
	}

	@Override
	public Account withdraw(String mobileNo) throws PaytmWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a == null) {
		throw new PaytmWalletException("The mobile number does not exist");
		}
		return a;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws PaytmWalletException {
		// TODO Auto-generated method stub
		Account a = paytmWalletMap.get(mobileNo);
		if (a== null) {
		throw new PaytmWalletException("The mobile number does not exist");
		}
		return a;
	}

	}


