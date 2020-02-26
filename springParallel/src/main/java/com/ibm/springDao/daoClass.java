package com.ibm.springDao;

import com.ibm.springBean.User;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/* import com.ibm.walletSpring.bean.User; */
@Repository("dao")
public class daoClass {
	DataSource datasource;

	NamedParameterJdbcTemplate namedParam;

	@Autowired
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;

		namedParam = new NamedParameterJdbcTemplate(datasource);
	}
	public void insertUser(User user) {
		String qry1 = "insert into userData(userName, phoneNumber) values(:uname, :uphoneNo)";
		String qry2 = "insert into balancedata(phoneNumber) values(:uphoneNo)";
		
		namedParam.update(qry1,
				new MapSqlParameterSource("uname", user.getuserName()).addValue("uphoneNo", user.getphoneNumber()));

		namedParam.update(qry2, new MapSqlParameterSource("uphoneNo", user.getphoneNumber()));
	}
	
	public void deposit(User user) {

		String qry3 = "update balancedata set Balance = Balance + :balance where phoneNumber = :uphoneNo";

		namedParam.update(qry3,
				new MapSqlParameterSource("balance", user.getBalance()).addValue("uphoneNo", user.getphoneNumber()));

	}
	public void withdraw(User user) {
		String qry4 = "select Balance from balancedata where phoneNumber = :uphoneNo";
		String qry5 = "update balancedata set Balance = Balance - :balance where phoneNumber = :uphoneNo";

		int curr_Balance = namedParam.queryForObject(qry4, new MapSqlParameterSource("uphoneNo", user.getphoneNumber()),
				Integer.class);

		if (curr_Balance < 2500 ) {
			System.out.println("You've got low Balance");
		} else {
			namedParam.update(qry5,
					new MapSqlParameterSource("balance", user.getBalance()).addValue("uphoneNo", user.getphoneNumber()));

		}
	}
		public void transfer(User user) {

			String qry6 = "insert into transactiondata(phoneNumber,FromUser,ToUser,Time, Amount) values(:uphoneNo,:ufromUser,:utoUser,:date,:uamount)";
			String qry7 = "update balancedata set balance=balance+:balance where phoneNumber= :uphoneNo"; //from-user
			String qry8 = "Update balancedata set balance=balance-:balance where phoneNumber = :uphoneNo";  //to-user

			Date t = new Date();

			namedParam.update(qry6,
					new MapSqlParameterSource("uphoneNumber", user.getphoneNumber()).addValue("ufromUser", user.getphoneNumber())
							.addValue("utoUser", user.gettophoneNumber()).addValue("date", t)
							.addValue("uamount", user.getBalance()));
			namedParam.update(qry7,
					new MapSqlParameterSource("balance", user.getBalance()).addValue("uphoneNumber", user.gettophoneNumber()));
			namedParam.update(qry8,
					new MapSqlParameterSource("balance", user.getBalance()).addValue("uphoneNumber", user.getphoneNumber()));

		}
		public List allUserData(User user)
		{
			
			String qry9="select FromUser, ToUser, Time, Amount from transactiondata where phoneNumber=:uphoneNo";
			
			List list = namedParam.queryForList(qry9, new MapSqlParameterSource("uphoneNo",user.getphoneNumber()));
			
			return list;
		}
		public String checkBalance(User user)
		{
			String curr_Bal="select Balance from balancedata where phoneNumber=:uphoneNo";
			
			return namedParam.queryForObject(curr_Bal, new MapSqlParameterSource("uphoneNo",user.getphoneNumber()),String.class);
			
		}

	}
	

	
	
	
	
	
	
	
	
	
	
	