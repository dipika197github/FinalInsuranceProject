package com.insurance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Premium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer premiumId;
	private Integer policyId;
	private String policyHolderName;
	private Double installmentPremiumAmount;
	private Date policyCommencementDate;
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPremiumId() {
		return premiumId;
	}

	public void setPremiumId(Integer premiumId) {
		this.premiumId = premiumId;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public Double getInstallmentPremiumAmount() {
		return installmentPremiumAmount;
	}

	public void setInstallmentPremiumAmount(Double installmentPremiumAmount) {
		this.installmentPremiumAmount = installmentPremiumAmount;
	}

	public Date getPolicyCommencementDate() {
		return policyCommencementDate;
	}

	public void setPolicyCommencementDate(Date policyCommencementDate) {
		this.policyCommencementDate = policyCommencementDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Premium [id=" + id + ", premiumId=" + premiumId + ", policyId=" + policyId + ", policyHolderName="
				+ policyHolderName + ", installmentPremiumAmount=" + installmentPremiumAmount
				+ ", policyCommencementDate=" + policyCommencementDate + "]";
	}

}
