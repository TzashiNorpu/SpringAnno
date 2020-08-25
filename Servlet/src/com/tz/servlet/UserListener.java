package com.tz.servlet;

import javax.servlet.*;

public class UserListener implements ServletContextListener {


    //监听ServletContext销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("UserListener...contextDestroyed...");
    }

    //监听ServletContext启动初始化
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("UserListener...contextInitialized...");
    }
}
