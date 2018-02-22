package com.mos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mos.domain.User;
import com.mos.repository.UserRepository;
import com.mos.service.UserService;

@Service
public class UserServicesImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User findByUserId(Integer userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public void editUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		
		userRepository.delete(userId);
		
	}



}
