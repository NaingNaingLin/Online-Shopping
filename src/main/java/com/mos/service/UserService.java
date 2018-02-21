package com.mos.service;

import java.util.List;

import com.mos.domain.User;

public interface UserService {
	
	void createUser(User user);
	List<User> findAllUser();
	User findByUserId(Integer userId);
	User findOneUser(Integer userId);
	void editUser(Integer userId);
	void deleteUser(Integer userId);
	
	

}
