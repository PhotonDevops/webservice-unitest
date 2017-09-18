package com.manulife.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Claim {
	
	@Id
	//@GeneratedValue
	private String claimid;
	private String taxonomy;
	private String email;
	private String name;
	private String status;
	private String fromDate;
	private String endDate;
	private String amountBilled;
	private String amountPaid;
	@Embedded private Hospital hospital;

	public Claim() {
		this.claimid = "";
		this.taxonomy = "";
		this.email = "";
		this.name = "";
		this.status = "";
		this.fromDate = "";
		this.endDate = "";
		this.amountBilled = "";
		this.amountPaid = "";
		this.hospital = null;
	}
	public Claim(String claimid, String taxonomy, String email, String name, String status, String fromDate, String endDate, String amountBilled, String amountPaid, Hospital hospital) {
		this.claimid = claimid;
		this.taxonomy = taxonomy;
		this.email = email;
		this.name = name;
		this.status = status;
		this.fromDate = fromDate;
		this.endDate = endDate;
		this.amountBilled = amountBilled;
		this.amountPaid = amountPaid;
		this.hospital = hospital;
	}
	
	public String getClaimId() {
		return claimid;
	}
	public void setClaimId(String claimid) {
		this.claimid = claimid;
	}
	public String getTaxonomy() {
		return taxonomy;
	}
	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAmountBilled() {
		return amountBilled;
	}
	public void setAmountBilled(String amountBilled) {
		this.amountBilled = amountBilled;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

		
}
