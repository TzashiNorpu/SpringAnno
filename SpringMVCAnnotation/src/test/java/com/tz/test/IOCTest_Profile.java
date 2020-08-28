package com.tz.test;

import javax.sql.DataSource;

import com.tz.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tz.bean.Boss;
import com.tz.bean.Car;
import com.tz.bean.Color;
import com.tz.bean.Red;
import com.tz.bean.Yellow;
import com.tz.config.MainConfigOfProfile;
import com.tz.config.MainConifgOfAutowired;
import com.tz.dao.BookDao;
import com.tz.service.BookService;

import java.util.Map;

public class IOCTest_Profile {
	
	//1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
	//2、代码的方式激活某种环境；
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext();
		//1、创建一个applicationContext
		//2、设置需要激活的环境
		// 加了 @Profile 注解 不设定激活环境的时候加了 @Profile 注解的组件都不会进入 IOC 容器
		applicationContext.getEnvironment().setActiveProfiles("prod","dev");
		//3、注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4、启动刷新容器
		applicationContext.refresh();
		
		
		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}

		/*DataSource datasourceBean = applicationContext.getBean(DataSource.class);
		System.out.println(datasourceBean);*/

		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		applicationContext.close();
	}

}
