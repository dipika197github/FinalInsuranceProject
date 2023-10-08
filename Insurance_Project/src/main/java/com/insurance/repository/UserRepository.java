package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.insurance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);

	public void deleteById(int id);

	public User findByEmail(String email);



	
}
