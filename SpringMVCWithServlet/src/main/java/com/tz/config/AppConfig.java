package com.tz.config;

import com.tz.controller.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

//SpringMVC只扫描Controller；子容器
//useDefaultFilters=false 禁用默认的过滤规则；
@ComponentScan(value = "com.tz", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    //        WebMvcConfigurerAdapter
    //定制
    //视图解析器
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认所有的页面都从 /WEB-INF/ xxx .jsp
        //registry.jsp();
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    //静态资源访问
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 相当于 <mvc:default-servlet-handler/>
        configurer.enable();
    }

    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }

}