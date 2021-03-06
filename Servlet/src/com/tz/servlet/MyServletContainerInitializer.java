package com.tz.servlet;


import com.tz.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；
//传入感兴趣的类型；
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 应用启动的时候，会运行onStartup方法；
     * <p>
     * Set<Class<?>> c：感兴趣的类型的所有子类型；
     * ServletContext ctx:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     * <p>
     * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
     *      自定义组件可以使用 @WebServlet 之类的注解进行注册，但是第三方的web三大组件不能用这种方式进行注册，只能用下面的方式注册
     * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
     * 必须在项目启动的时候来添加；
     * 1）、ServletContainerInitializer得到的ServletContext；
     * 2）、ServletContextListener得到的ServletContext；
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类型：");
        for (Class<?> claz : c) {
            System.out.println(claz);
        }

        //注册组件  ServletRegistration
        ServletRegistration.Dynamic servlet = ctx.addServlet("userServlet", new UserServlet());
        //配置servlet的映射信息
        servlet.addMapping("/user");


        //注册Listener
        ctx.addListener(UserListener.class);

        //注册Filter  FilterRegistration
        FilterRegistration.Dynamic filter = ctx.addFilter("userFilter", UserFilter.class);
        //配置Filter的映射信息
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }


}
