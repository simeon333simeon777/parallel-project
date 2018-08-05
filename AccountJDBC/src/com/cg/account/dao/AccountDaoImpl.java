package com.cg.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import com.cg.account.bean.Account;
import com.cg.account.db.AccountDb;
import com.cg.account.exception.AccountException;

public class AccountDaoImpl implements AccountDao {

	@Override
	public String createNewAccount(Account acc) throws AccountException {
		Connection con=AccountDb.getConnection();
		PreparedStatement stat;
		try{
		con.setAutoCommit(false);
		stat = con.prepareStatement(QueryMapper.insert);
		stat.setString(1, acc.getName());
		stat.setString(2, acc.getEmailId());
		stat.setString(3, acc.getPhoneNo());
		stat.setDouble(4, acc.getBalance());
		int res=stat.executeUpdate();
		if(res==1){
		con.commit();
		return acc.getPhoneNo();
		}else{
		throw new AccountException("Could not create account");
		}
		 
		} 
		catch (SQLException e) {
				throw new AccountException(e.getMessage());
		}		 
		}	

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		Connection con=AccountDb.getConnection();
		PreparedStatement stat;
		try{
		stat=con.prepareStatement(QueryMapper.getBal);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		con.commit();
		if(rs!=null){
		rs.next();
		return rs.getDouble("balance");
		}else{
		throw new AccountException("mobile no does not exists");
		}		 
		}
		catch (SQLException e) {
				throw new AccountException(e.getMessage());
		} 		
	}

	@Override
	public Account deposit(String mobileNo,double depositAmt) throws AccountException {
		Connection con=AccountDb.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{		 
		stat=con.prepareStatement(QueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		if(rs!=null){
		rs.next();
		Account account1=new Account();
		double balance=rs.getDouble("balance")+depositAmt;
		account1.setName(rs.getString("name"));
		account1.setPhoneNo(rs.getString("mobileno"));
		account1.setBalance(balance);
		account1.setEmailId(rs.getString("email"));
		account1.setDate(Date.valueOf(LocalDate.now()));		 
		stat1=con.prepareStatement(QueryMapper.update);
		stat1.setDouble(1, account1.getBalance());
		stat1.setDate(2, account1.getDate());
		stat1.setString(3, account1.getPhoneNo());
		int rs1=stat1.executeUpdate();		 
		if(rs1==1)
		{		 
		con.commit();		 
		return account1;
		}
		else{
		throw new AccountException("balance is not updated");
		}		 
		}
		else{
		throw new AccountException("mobile no does not exists");
		}		 
		}
		catch (SQLException e) {
				throw new AccountException(e.getMessage());
		}		
	}

	@Override
	public Account withdraw(String mobileNo, double withdrawAmt) throws AccountException {
		Connection con=AccountDb.getConnection();
		PreparedStatement stat;
		PreparedStatement stat1;
		try{		 
		stat=con.prepareStatement(QueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		if(rs!=null){
		rs.next();
		Account account=new Account();
		double balance=rs.getDouble("balance")-withdrawAmt;
		account.setName(rs.getString("name"));
		account.setPhoneNo(rs.getString("phoneNumber"));
		account.setBalance(balance);
		account.setEmailId(rs.getString("email"));
		account.setDate(Date.valueOf(LocalDate.now()));
		stat1=con.prepareStatement(QueryMapper.update);
		stat1.setDouble(1, account.getBalance());
		stat1.setDate(2, account.getDate());
		stat1.setString(3, account.getPhoneNo());
		int rs1=stat1.executeUpdate();		 
		if(rs1==1){
		con.commit();
		return account;
		}else{
		throw new AccountException("mobile no does not exists");
		}
		}
		else{
		throw new AccountException("mobile no does not exists");
		}		 
		}
		catch (SQLException e) {
		throw new AccountException(e.getMessage());
		}		
	}

	@Override
	public Account printTransactionDetails(String mobileNo)	throws AccountException {
		Connection con=AccountDb.getConnection();
		PreparedStatement stat;
		try{
		stat=con.prepareStatement(QueryMapper.getacc);
		stat.setString(1, mobileNo);
		ResultSet rs=stat.executeQuery();
		con.commit();
		if(rs!=null){
		rs.next();
		Account account=new Account();
		account.setName(rs.getString("name"));
		account.setPhoneNo(rs.getString("mobileno"));
		account.setEmailId(rs.getString("email"));
		account.setBalance(rs.getDouble("balance"));
		account.setDate(rs.getDate("date1"));
		return account;
		}else{
		throw new AccountException("mobile no does not exists");
		}		 
		}
		catch (SQLException e) {		
		throw new AccountException(e.getMessage());
		}
		 
		}

	}



