package com.insurance.service;

import java.util.List;

import com.insurance.model.User;

public interface UserService {

	// Build the Restful API to add user details into database
	public User saveUser(User user);

	// Build the Restful API to update user details into database
	public User updateUser(User user);

	// Build the Restful API to get user details from database
	public User getUser(int id);

	// Build the Restful API to delete the user details from database
	public void deleteByUserId(int id);

	// Build the Restful API to fetch all user details from database
	public List<User> getAllUserDetails();

	public User getEmail(String email) throws Exception;
}
