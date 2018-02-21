package com.mos.service;

import java.util.List;

import com.mos.domain.User;

public interface UserService {
	
	void createUser(User user);
	List<User> findAll();
	User findByUserId(Integer userId);
	User findOne(Integer userId);
	void delete(Integer userId);

}
