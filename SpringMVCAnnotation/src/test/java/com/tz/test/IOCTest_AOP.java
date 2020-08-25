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

public class IOCTest_AOP {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		
		//1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
		
		mathCalculator.div(1, 0);
		
		applicationContext.close();
	}

}
