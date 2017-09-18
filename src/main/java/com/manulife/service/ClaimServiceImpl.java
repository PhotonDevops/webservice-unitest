package com.manulife.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manulife.model.Claim;
import com.manulife.repository.ClaimRepository;

@Service("claimService")
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimRepository claimRepository; 

	@Override
	public Claim getClaimById(String claimid) {
		return claimRepository.findOne(claimid);
	}

	@Override
	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}

}
