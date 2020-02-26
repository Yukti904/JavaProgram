package com.ibm.springParallel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.springUI.UI;

//import com.ibm.walletSpring.ui.walletSpringUI;

public class App 
{
    public static void main( String[] args )
    {
       
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
    	
    	UI u = (UI)context.getBean("UI", UI.class);
    	
    	
      	u.choose();
    	
    }
}
