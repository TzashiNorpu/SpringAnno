package com.tz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tz.bean.Car;
import com.tz.bean.Color;
import com.tz.dao.BookDao;


/**
 * 自动装配;
 * Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；
 * <p>
 * 1）、@Autowired：自动注入：
 * 1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
 * 2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 * applicationContext.getBean("bookDao")
 * 3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 * 4）、自动装配默认一定要将属性赋值好，没有就会报错；
 * 可以使用@Autowired(required=false);
 * 5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean,而不管组件的 id，当然在需要自动注入的组件处指定了组件名称@Qualifier，则 Qualifier 生效；
 * 也可以继续使用@Qualifier指定需要装配的bean的名字
 * <p>
 * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 *
 * //@Resource: 可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 * 不支持 @Primary功能 不支持 @Autowired（reqiured=false） 的功能
 * //@Autowired 可以配合 @Qualifier 使用， @Resource 不可以
 * //@Inject: 需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
 * //@Autowired:Spring定义的； @Resource、@Inject都是java规范
 * <p>
 * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能
 * <p>
 * 3）、 @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值   Boss.java
 * 1）、[标注在方法位置]： 参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配；--> Boss.java:25L
 * 2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 * 3）、放在参数位置：public void setCar(@Autowired Car car) {} and @Bean+方法参数(见下面代码 71L )；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
 * <p>
 * <p>
 * 4）、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）；
 * 自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件；Aware；
 * 把Spring底层一些组件注入到自定义的Bean中；
 * xxxAware：功能使用xxxProcessor；
 * ApplicationContextAware==》ApplicationContextAwareProcessor；
 */
@Configuration
@ComponentScan({
        "com.tz.service",
        "com.tz.dao",
        "com.tz.controller",
        "com.tz.bean"
})
public class MainConifgOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    /**
     * //@Bean标注的方法创建对象的时候，方法参数的值从容器中获取
     */
    @Bean
    public Color color(Car car) {
        // 这两行的代码作用是一样的
//    public Color color(@Autowired Car car) {
//        @ComponentScan 处不加入 "com.tz.bean" 项时 参数 (Car car) 处报错
        Color color = new Color();
        color.setCar(car);
        return color;
    }


}
