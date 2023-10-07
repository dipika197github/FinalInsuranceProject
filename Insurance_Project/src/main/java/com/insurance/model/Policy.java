package com.insurance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int policyId;
	private String policyNumber;
	private Date policyEffectiveDate;
	private Date policyExpiryDate;
	private String payment_Option;
	private Double totalAmount;
	private Boolean status;
	private Date createdDate;
	private String additionalInfo;
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public Date getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}
	public void setPolicyEffectiveDate(Date policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}
	public Date getPolicyExpiryDate() {
		return policyExpiryDate;
	}
	public void setPolicyExpiryDate(Date policyExpiryDate) {
		this.policyExpiryDate = policyExpiryDate;
	}
	public String getPayment_Option() {
		return payment_Option;
	}
	public void setPayment_Option(String payment_Option) {
		this.payment_Option = payment_Option;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyNumber=" + policyNumber + ", policyEffectiveDate="
				+ policyEffectiveDate + ", policyExpiryDate=" + policyExpiryDate + ", payment_Option=" + payment_Option
				+ ", totalAmount=" + totalAmount + ", status=" + status + ", createdDate=" + createdDate
				+ ", additionalInfo=" + additionalInfo + "]";
	}
	
}