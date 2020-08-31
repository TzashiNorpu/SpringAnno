package com.tz.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	// 实现监听的另外一种方式，普通业务组件中可以用这种方式而不是实现接口
	@EventListener(classes={ApplicationEvent.class})
	public void listen(ApplicationEvent event){
		System.out.println("UserService...监听到的事件："+event);
	}

}
