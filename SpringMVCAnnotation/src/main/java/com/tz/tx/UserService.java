package com.tz.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


<<<<<<< HEAD
@Service("userServiceTx")
=======
@Service()
>>>>>>> 4d36ea44b284a1819c99988660afab26eeaac763
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void insertUser(){
		userDao.insert();
		//otherDao.other();xxx
		System.out.println("插入完成...");
		int i = 10/0;
	}

}
