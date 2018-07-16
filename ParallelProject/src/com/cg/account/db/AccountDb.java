package com.cg.account.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.account.bean.Account;



public class AccountDb {
	private static HashMap<String,Account> accDb=new HashMap<String,Account>();
	static{
		accDb.put("9978456321",new Account("rajesh","9922943943",1100,"Ajay@gmail.com",LocalDateTime.now()) );
		accDb.put("9912365478", new Account("Ajith","9922943923",1200,"Ajith@gmail.com",LocalDateTime.now()));
		accDb.put("8974563215", new Account("Vamsi","9922943523",1300,"Vamsi@gmail.com",LocalDateTime.now()));
		accDb.put("8974563215", new Account("Tarun","9922943633",1400,"Tarun@gmail.com",LocalDateTime.now()));
		accDb.put("8974563215", new Account("Aksah","9922943999",1500,"Aksah@gmail.com",LocalDateTime.now()));
	}
	public static HashMap<String,Account> getAccDb() {
		return accDb;
	}
}
