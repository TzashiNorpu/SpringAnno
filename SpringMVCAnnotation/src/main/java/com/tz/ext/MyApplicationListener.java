package com.tz.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
	@Override
	//当容器中发布此事件以后，方法触发
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到事件："+event);
	}

}
