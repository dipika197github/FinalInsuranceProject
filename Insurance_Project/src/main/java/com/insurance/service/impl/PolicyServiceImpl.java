package com.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.Policy;
import com.insurance.repository.PolicyRepository;
import com.insurance.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService{

	@Autowired
	private PolicyRepository policyRepository;
	@Override
	public Policy savePolicy(Policy policy) {
		 Policy policies=policyRepository.save(policy);
		return policies;
	}
	@Override
	public Policy updatePolicy(Policy policy) {
		System.out.println("this is service imp");
		Policy policyUpdate= policyRepository.save(policy);
		return policyUpdate;
	}
	@Override
	public Policy findByPolicyId(int id) {
		Policy policyId=policyRepository.findById(id);
		return policyId;
	}
	@Override
	public void deleteByPolicyId(int id) {
		policyRepository.deleteById(id);
		
	}
	@Override
	public List<Policy> getAllPolicy() {
		List<Policy> policyList=policyRepository.findAll();
		return policyList;
	}
	@Override
	public void deleteAllPolicyDetailse() {
		policyRepository.deleteAll();
		
	}
	

}
