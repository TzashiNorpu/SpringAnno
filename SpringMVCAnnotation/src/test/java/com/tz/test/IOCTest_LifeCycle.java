package com.tz.test;

import com.tz.bean.Car;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tz.config.MainConfigOfLifeCycle;

import java.util.Map;

public class IOCTest_LifeCycle {
	
	@Test
	public void test01(){
		//1、创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成...");
		System.out.println("***********************************");
		printBeans(applicationContext);
		System.out.println("***********************************");
//		car1和car2不在容器中
		Object car1 = applicationContext.getBean("car");
		Object car2 = applicationContext.getBean("car");
		/*System.out.println("car1:"+car1);
		System.out.println("car2:"+car2);*/

		Map<String, Car> beans = applicationContext.getBeansOfType(Car.class);
		for (Map.Entry<String,Car> entry: beans.entrySet()
			 ) {
			System.out.println("bean name:"+entry.getKey()+";bean instance:"+entry.getValue()+"\n");
		}
		//关闭容器
		applicationContext.close();
	}
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
}
