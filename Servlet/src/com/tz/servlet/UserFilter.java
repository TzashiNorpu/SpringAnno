package com.tz.servlet;

import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 过滤请求
        System.out.println("UserFilter...doFilter...");
        // 放行
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
