package com.insurance.service;

import java.util.List;

import com.insurance.model.Policy;

public interface PolicyService {

	public Policy savePolicy(Policy policy);

	// Design API to update policy details into database
	public Policy updatePolicy(Policy policy);

	// Design Restful Api to get the Policy using Id
	public Policy findByPolicyId(int id);

	// Design RestFulApi delete policy by using id
	public void deleteByPolicyId(int id);

	// Get All Policies Details
	public List<Policy> getAllPolicy();

//Design Restful API to delete the policy details from systems
	public void deleteAllPolicyDetailse();

}
