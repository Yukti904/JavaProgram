package com.ibm.springService;

import java.util.List;
import com.ibm.springBean.User;
import com.ibm.springDao.daoClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service; 

@Service("service")
public class serviceClass {
		@Autowired
		daoClass dao;
			
		public void insertUser(User user)
		{
			dao.insertUser(user);
		}
		
		public void deposit(User user)
		{
		dao.deposit(user);
		}
		
		public void withdraw(User user)
		{
			dao.withdraw(user);
		}
		
		public void transfer(User user)
		{
			dao.transfer(user);
		}
		public List allUserData(User user)
		{
			return dao.allUserData(user);
		}
		
		public String checkBalance(User user)
		{
			return dao.checkBalance(user);
		}
		
		
		
	}


