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

import com.insurance.model.Premium;
import com.insurance.service.PremiumService;

@RestController
@RequestMapping("premiumdetails")
public class PremiumController {
	@Autowired
	private PremiumService premiumService;
	@PostMapping("/savePremium")
	public Premium savePremium(@RequestBody Premium premium) {
		Premium premium1=premiumService.savePremium(premium);
		return premium1;
	}
	@PutMapping("/updatePremium")
	public Premium updatePremium(@RequestBody Premium premium) {
		Premium updatePremium=premiumService.updatePremium(premium);
		return updatePremium;
	}
	@GetMapping("/getAllPremiumDetails")
	public List<Premium> getAllPremiumDetails() {
		List<Premium> premiumList=premiumService.getAllPremiumDetails();
		return premiumList;
	}
	@DeleteMapping("/deleteByPremiumId/{deleteId}")
	public void deleteByPremiumId(@PathVariable("deleteId") int deleteId) {
		premiumService.deleteByPremiumId(deleteId);
	}
}
