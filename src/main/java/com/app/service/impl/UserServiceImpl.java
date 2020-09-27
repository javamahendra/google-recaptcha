package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.User;
import com.app.repo.UserRepository;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Long createUser(User user) {
		
		return userRepository.save(user).getId();
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
}
