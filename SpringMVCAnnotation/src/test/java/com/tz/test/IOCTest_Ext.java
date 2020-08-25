package com.tz.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tz.aop.MathCalculator;
import com.tz.bean.Boss;
import com.tz.bean.Car;
import com.tz.bean.Color;
import com.tz.bean.Red;
import com.tz.config.MainConfigOfAOP;
import com.tz.config.MainConifgOfAutowired;
import com.tz.dao.BookDao;
import com.tz.ext.ExtConfig;
import com.tz.service.BookService;

public class IOCTest_Ext {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);
		
		
		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的时间")) {
		});
		
		applicationContext.close();
	}

}
