package com.tz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.tz.bean.Car;

/**
 * bean的生命周期：
 * 		bean创建---初始化----销毁的过程
 * 容器管理bean的生命周期；
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 
 * 构造（对象创建）
 * 		单实例：在容器启动的时候创建对象
 * 		多实例：在每次获取的时候创建对象
 *
 *
 *
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 * 		对象创建完成，并赋值好，然后调用初始化方法。。。
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 * 		单实例：容器关闭的时候
 * 		多实例：容器不会管理这个bean；容器不会调用销毁方法；
 * 
 * 
 * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 * 
 * BeanPostProcessor原理(AbstractAutowireCapableBeanFactory.java)
 * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * initializeBean
 * {
 * 		applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * 		invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 * 		applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *}
 *
 * 1）、指定初始化和销毁方法；
 * 		通过@Bean指定init-method和destroy-method： 下面的代码
 * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
 * 				DisposableBean（定义销毁逻辑）: Cat 类
 * 3）、可以使用JSR250； Dog 类
 * 		//@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法   InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization
 * 		//@PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * 4）、BeanPostProcessor【interface】：bean的后置处理器；
 * 		在bean <b>初始化前后</>进行一些处理工作 : MyBeanPostProcessor
 * 		postProcessBeforeInitialization:在初始化之前工作
 * 		postProcessAfterInitialization:在初始化之后工作
 * 
 * Spring底层对 BeanPostProcessor 的使用；
 * 		bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
 * ApplicationContextAware 往类中注入组件，由 ApplicationContextAwareProcessor 实现 --> ApplicationContextAwareProcessor.invokeAwareInterfaces 方法
 * 	Dog 类和 Red 类
 * @author lfy
 *
 */
@ComponentScan("com.tz.bean")
@Configuration
public class MainConfigOfLifeCycle {
//	覆盖容器中相同ID的组件
//	@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destroy")
	public Car car(){
		return new Car("BMW");
	}

	public MainConfigOfLifeCycle() {
		System.out.println("MainConfigOfLifeCycle...constructor...");
	}
}
