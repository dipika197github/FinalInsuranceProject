package com.insurance.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	// For User Table
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

	// For Policy Table
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

	// For Premium Table
	@PostMapping("/savePremium")
	public Premium savePremium(@RequestBody Premium premium) {
		Premium premium1 = premiumService.savePremium(premium);
		return premium1;
	}

	@PutMapping("/updatePremium")
	public Premium updatePremium(@RequestBody Premium premium) {
		Premium updatePremium = premiumService.updatePremium(premium);
		return updatePremium;
	}

	@GetMapping("/getAllPremiumDetails")
	public List<Premium> getAllPremiumDetails() {
		List<Premium> premiumList = premiumService.getAllPremiumDetails();
		return premiumList;
	}

	@DeleteMapping("/deleteByPremiumId/{deleteId}")
	public void deleteByPremiumId(@PathVariable("deleteId") int deleteId) {
		premiumService.deleteByPremiumId(deleteId);
	}

	@GetMapping("/getPremiumsInDuration")
	public ResponseEntity<List<Premium>> getPremiumsInDuration(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		try {
			List<Premium> premiums = premiumService.getPremiumsInDuration(startDate, endDate);
			if (premiums.isEmpty()) {
				return ResponseEntity.noContent().build();// No premiums found
			}
			return ResponseEntity.ok(premiums);// Return premiums in JSON format
		} catch (Exception e) {
			// Handle other errors, e.g., database errors
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	@GetMapping("/updatePassword/{email}")
	public boolean updatePassword(@PathVariable("email") String email,@RequestParam("password") String password) throws Exception {
		User user=userService.getEmail(email);
		if(user != null) {
			user.setPassword(password);
			userService.updateUser(user);
			return true;
			
		}
		return false;
		
	}

}