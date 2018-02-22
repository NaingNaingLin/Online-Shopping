package com.mos.service;

import java.util.List;

import com.mos.domain.User;

public interface UserService {
	
	void createUser(User user);
	List<User> findAllUser();
	User findByUserId(Integer userId);
	void editUser(User user);
	void deleteUser(Integer userId);
	
	

}
