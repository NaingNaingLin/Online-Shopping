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
		userRepository.saveAndFlush(user);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByUserId(Integer userId) {

		return userRepository.findOne(userId);
	}
}
