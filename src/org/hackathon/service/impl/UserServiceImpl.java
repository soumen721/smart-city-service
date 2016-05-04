package org.hackathon.service.impl;

import org.hackathon.dao.UserDao;
import org.hackathon.domain.User;
import org.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean isValidUser(User user) {
		
		return userDao.isValidUser(user);
	}

}
