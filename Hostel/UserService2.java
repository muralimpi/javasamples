package com.rakesh.Mvc.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service()
public class UserService2 {
	@Autowired
	UserDao userDao;
	
	
	public boolean add(Login login) {
		userDao.addLogin(login);
	   return true;
}
	public boolean add(User user) {
		userDao.addUser(user);
		return true;
	}
}