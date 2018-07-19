package com.cg.paytmwallet.service;

import java.time.LocalDateTime;
import java.util.HashMap;







import com.cg.paytmwallet.db.PaytmWalletDb;
import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.dao.PatymWalletDao;
import com.cg.paytmwallet.dao.PaytmWalletImpl;
import com.cg.paytmwallet.exception.PaytmWalletException;

public class PaytmWalletServiceImpl implements PaytmWalletService {
	PatymWalletDao dao = new PaytmWalletImpl();
	
	@Override
	public String createAccount(Account a) throws PaytmWalletException {
		// TODO Auto-generated method stub

	    
		if (a.getName().isEmpty() || a.getName() == null) {
			throw new PaytmWalletException("Name cannot be empty");
			}
		else {
		if (!a.getName().matches("[A-Z][A-Za-z]{2,}")) {
			throw new PaytmWalletException("Name should start with capital letter and should contain only alphabets");
			}
			}
		
	    if (!a.getMobileNo().matches("\\d{10}")) {
	    	throw new PaytmWalletException("Mobile number should contain 10 digits");
	    	}
	    if (a.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) {
			throw new PaytmWalletException("Enter valid emailid");
			}
	    return dao.createAccount(a);
	
	}

	@Override
	public double showBalance(String mobileNo) throws PaytmWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
		return dao.showBalance(mobileNo);
	
	}

	@Override
	public Account deposit(String mobileNo, double depositAmount)
			throws PaytmWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			Account a = dao.deposit(mobileNo);
			if (depositAmount <= 0) {
			throw new PaytmWalletException("Deposit amount must be greater than zero");
			}
			a.setBalance(a.getBalance() + depositAmount);
			a.setDate(LocalDateTime.now());
		return a;
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmount)
			throws PaytmWalletException {
		// TODO Auto-generated method stub
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			Account a = dao.withdraw(mobileNo);
			if (withdrawAmount > a.getBalance() || withdrawAmount <= 0) {
			throw new PaytmWalletException(
			"The amount to be withdrawn should be greater than available balance and greater than zero");
			}
			a.setBalance(a.getBalance() - withdrawAmount);
			a.setDate(LocalDateTime.now());
		return a;
		
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destinationMobileNo,
			double transferAmount) throws PaytmWalletException {
		// TODO Auto-generated method stub
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			if (!destinationMobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			PaytmWalletService service = new PaytmWalletServiceImpl();
			Account a1 = service.withdraw(sourceMobileNo, transferAmount);
			Account a2 = service.deposit(destinationMobileNo, transferAmount);
			return false;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws PaytmWalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
		return dao.printTransactionDetails(mobileNo);
	}
}


