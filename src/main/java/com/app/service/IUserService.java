package com.app.service;

import java.util.List;

import com.app.domain.User;

public interface IUserService {
	
	public Long createUser(User user);
	public List<User> getAllUsers();
}
