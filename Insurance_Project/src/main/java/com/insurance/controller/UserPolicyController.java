package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.model.Policy;
import com.insurance.model.Premium;
import com.insurance.model.User;
import com.insurance.service.PolicyService;
import com.insurance.service.PremiumService;
import com.insurance.service.UserService;

@RestController
@RequestMapping("userpolicy")
public class UserPolicyController {

	@Autowired
	private UserService userService;
	@Autowired
	private PolicyService policyService;
	@Autowired
	private PremiumService premiumService;

	// User WebService(API)
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		User users = userService.saveUser(user);
		List<Premium> premium = user.getPremiumList();
		for (Premium premiums : premium) {
			premiums.setUserId(user.getId());
			premiumService.savePremium(premiums);
		}
		return users;
	}

	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		User userUpdate = userService.updateUser(user);
		return userUpdate;
	}

	@GetMapping("/findByUserId/{id}/{premiumId}")
	public User findByUserId(@PathVariable("id") int id, @PathVariable("premiumId") int premiumId) {
		User user = userService.getUser(id);
		List<Premium> premiumList = premiumService.getPremiumById(premiumId);
		for (Premium premium : premiumList) {
			user.setId(premium.getUserId());
			user.setPremiumList(premiumList);

		}
		return user;
	}

	@DeleteMapping("/deleteByUserId/{id}")
	public void deleteByUserId(@PathVariable("id") int id) {
		userService.deleteByUserId(id);

	}

	@GetMapping("/getAllUserDetails")
	public List<User> getAllUserDetails() {
		List<User> userList = userService.getAllUserDetails();
		return userList;
	}

	// User WebService(API)
	@PostMapping("/savePolicy")
	public Policy savePolicy(@RequestBody Policy policy) {
		Policy policies = policyService.savePolicy(policy);
		return policies;
	}

	@PutMapping("/updatePolicy")
	public Policy updatePolicy(@RequestBody Policy policy) {
		Policy policyUpdate = policyService.updatePolicy(policy);
		return policyUpdate;
	}

	@GetMapping("/findByPolicyId/{policyid}")
	public Policy findByPolicyId(@PathVariable("policyid") int policyid) {
		Policy policyId = policyService.findByPolicyId(policyid);
		return policyId;
	}

	@DeleteMapping("/deleteByPolicyId/{deleteId}")
	public void deleteByPolicyId(@PathVariable("deleteId") int deleteId) {
		policyService.deleteByPolicyId(deleteId);
	}

	@GetMapping("/getAllPolicy")
	public List<Policy> getAllPolicy() {
		List<Policy> policyList = policyService.getAllPolicy();
		return policyList;
	}

	@DeleteMapping("/deleteAllPolicyDetailse")
	public void deleteAllPolicyDetailse() {
		policyService.deleteAllPolicyDetailse();
	}

}