package com.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.insurance.model.User;
import com.insurance.repository.UserRepository;
import com.insurance.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User users = userRepository.save(user);
		return users;
	}

	@Override
	public User updateUser(User user) {
		User userUpdate = userRepository.save(user);
		return userUpdate;
	}

	@Override
	public User getUser(int id) {
		User user = userRepository.findById(id);
		return user;
	}

	@Override
	public void deleteByUserId(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User getEmail(String email) throws Exception {
		User user=userRepository.findByEmail(email);
		if(user == null) {
			throw new Exception("User not found");
		}
		return user;
		
	
	}
}
