package com.cg.account.service;

import com.cg.account.bean.Account;
import com.cg.account.dao.AccountDaoImpl;
import com.cg.account.dao.AccountDao;
import com.cg.account.exception.AccountException;

public class AccountServiceImpl implements AccountService {
	AccountDao dao = new AccountDaoImpl();
	@Override
	public String createNewAccount(Account account) throws AccountException {
		if (!account.getPhoneNo().matches("\\d{10}")) {
			throw new AccountException("Phone number should be 10 digits");
			}
			if (account.getName().isEmpty() || account.getName() == null) {
			throw new AccountException("Name cannot be empty");
			} else {
			if (!account.getName().matches("[A-Z][A-Za-z]{3,}")) {
			throw new AccountException("Name should start with capital letter with minimum 3 characters and should contain only alphabets");
			}
			}
			if (account.getBalance() < 0) {
			throw new AccountException("Balance should be greater than zero");
			}
			if (!account.getEmailId().matches("[a-z]+@[a-z]+\\.com")) {
			throw new AccountException("Enter valid emailid");
			}
			return dao.createNewAccount(account);
	}

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
			}
			return dao.showBalance(mobileNo);
	}

	@Override
	public Account printTransactionDetails(String mobileNo) throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
			}
		
		return dao.printTransactionDetails(mobileNo);

	}

	@Override
	public Account deposit(String mobileNo, double depositAmt)	throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
			}
			if (depositAmt <= 0) 
			{
			throw new AccountException("Deposit amount must be greater than zero");
			}			 
			return dao.deposit(mobileNo,depositAmt);			
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmt) throws AccountException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
			}			
			if ( withdrawAmt <= 0) {
			throw new AccountException("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero");
			}			
			Account account1 = dao.withdraw(mobileNo,withdrawAmt);
			return account1;
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,	double transferAmt) throws AccountException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
			}
			if (!destMobileNo.matches("\\d{10}")) {
			throw new AccountException("Mobile number should contain 10 digits");
			}
			if(transferAmt<=0){
				throw new AccountException("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero");
			}
			AccountServiceImpl service = new AccountServiceImpl();
			service.withdraw(sourceMobileNo, transferAmt);
			service.deposit(destMobileNo, transferAmt);
			return true;
	}

	
}
