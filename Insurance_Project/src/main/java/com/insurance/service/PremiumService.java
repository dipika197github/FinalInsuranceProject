package com.insurance.service;

import java.util.Date;
import java.util.List;

import com.insurance.model.Premium;

public interface PremiumService {

	// Design API to save all the premium details into database
	public Premium savePremium(Premium premium);

	// Design API to update premium details into database
	public Premium updatePremium(Premium premium);

	// Design API to get all the premium details from database
	public List<Premium> getAllPremiumDetails();

	// Design API to get user with multiple premium details from database
	public List<Premium> getPremiumById(int id);

	// Design API to delete premium details from database
	public void deleteByPremiumId(int id);
	
	/*/
	 * Build the Restful web service to get all the policy premium details
	 *  for specific duration
	 */
	List<Premium> getPremiumsInDuration(Date startDate, Date endDate);

}
