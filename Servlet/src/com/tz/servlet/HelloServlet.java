package com.tz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Servlet 异步请求
        System.out.println(Thread.currentThread() + " start...");
        try {
            // 这里是同步模式：同步用的是同一个线程  会在这里堵塞  异步不会
            sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.getWriter().write("hello...");
        System.out.println(Thread.currentThread() + " end...");
    }

    public void sayHello() throws Exception {
        System.out.println(Thread.currentThread() + " processing...");
        Thread.sleep(3000);
    }
}
