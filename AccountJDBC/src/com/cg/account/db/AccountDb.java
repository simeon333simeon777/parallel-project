package com.cg.account.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.account.exception.AccountException;

public class AccountDb {
	public static Connection getConnection() throws AccountException{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url,"system","root");
		}catch(ClassNotFoundException e){
		throw new AccountException(e.getMessage());
		}catch(SQLException e1){
		throw new AccountException(e1.getMessage());
		}
		 
		 
		}
}
