package com.tz.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tz.aop.MathCalculator;
import com.tz.bean.Boss;
import com.tz.bean.Car;
import com.tz.bean.Color;
import com.tz.bean.Red;
import com.tz.config.MainConfigOfAOP;
import com.tz.config.MainConifgOfAutowired;
import com.tz.dao.BookDao;
import com.tz.service.BookService;
import com.tz.tx.TxConfig;
import com.tz.tx.UserService;

public class IOCTest_Tx {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(TxConfig.class);
	
		UserService userService = applicationContext.getBean(UserService.class);
		
		userService.insertUser();
		applicationContext.close();
	}

}
