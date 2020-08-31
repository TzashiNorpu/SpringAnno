package com.tz.test;

import com.tz.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tz.aop.MathCalculator;
import com.tz.config.MainConfigOfAOP;
import com.tz.config.MainConifgOfAutowired;
import com.tz.dao.BookDao;
import com.tz.ext.ExtConfig;
import com.tz.service.BookService;

import java.util.Iterator;
import java.util.Map;

public class IOCTest_Ext {

	private Iterator<Map.Entry<String, Blue>> iterator;

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(ExtConfig.class);
		
		
		//发布事件；
		applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
		});

		Map<String, Blue> beans = applicationContext.getBeansOfType(Blue.class);
		iterator = beans.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		applicationContext.close();
	}

}
