package com.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.Premium;
import com.insurance.repository.PremiumRepository;
import com.insurance.service.PremiumService;
@Service
public class PremiumServiceImpl implements PremiumService{

	@Autowired
	private PremiumRepository premiumRepository;
	@Override
	public Premium savePremium(Premium premium) {
		Premium premiums=premiumRepository.save(premium);
		return premiums;
	}
	@Override
	public Premium updatePremium(Premium premium) {
		Premium updatePremium=premiumRepository.save(premium);
		return updatePremium;
	}
	@Override
	public List<Premium> getAllPremiumDetails() {
		List<Premium> premiumList=premiumRepository.findAll();
		return premiumList;
	}
	@Override
	public void deleteByPremiumId(int id) {
		premiumRepository.deleteById(id);
		
	}
	@Override
	public List<Premium> getPremiumById(int id) {
		List<Premium> premiumList=premiumRepository.findById(id);
		return premiumList;
	}

}
