package com.cg.paytmwallet.db;

import java.time.LocalDateTime;
import java.util.HashMap;
import com.cg.paytmwallet.bean.Account;

public class PaytmWalletDb {
	private static HashMap<String,Account> paytmWalletDb=new HashMap<String,Account>();
	public static HashMap<String, Account> getPaytmWalletMap() {
	return paytmWalletDb;
	}
	Account o= new Account();
	static{
	 
	paytmWalletDb.put("7981123927",new Account("7981123927","Simeon","simeon777@gmail.com",5000.0,LocalDateTime.now()));
	paytmWalletDb.put("8019653338",new Account("8019653338","Prasad","prasad333@gmail.com",2000.0,LocalDateTime.now()));
	paytmWalletDb.put("7997776202",new Account("7997776202","Baburao","baburao731@gmail.com",1500.0,LocalDateTime.now()));
	paytmWalletDb.put("9059849344",new Account("9059849344","Lakshmi","lakshmi137@gmail.com",1000.0,LocalDateTime.now()));
	}

}
