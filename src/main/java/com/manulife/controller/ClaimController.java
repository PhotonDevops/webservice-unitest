package com.manulife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manulife.constant.ClaimConstants;
import com.manulife.model.Claim;
import com.manulife.service.ClaimService;
import com.manulife.util.CustomErrorType;

@CrossOrigin("http://manulife-claim-dockermgmt.centralus.cloudapp.azure.com:5050")
@RestController
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "manulife/claimall", method = RequestMethod.GET)
    public ResponseEntity<List<Claim>> getClaims(@RequestHeader(value = "clientID", required = true) String clientID,@RequestHeader(value = "tokenID", required = true)String tokenID , @RequestHeader(value = "sessionID", required = true)String sessionID) {
    	
		if (sessionID.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Invalid Session ID # " + sessionID 
					), HttpStatus.NOT_FOUND);
		}
		
		if (!sessionID.equals(ClaimConstants.SESSION_ID)) {
			return new ResponseEntity(new CustomErrorType("Invalid Session ID # " + sessionID 
					), HttpStatus.NOT_FOUND);
		}
		if (clientID.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Clinet ID# " + clientID 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
    	if (tokenID.isEmpty()) {
    		return new ResponseEntity(new CustomErrorType("TokenID ID# " + tokenID 
				+ " not found"), HttpStatus.NOT_FOUND);
    	}
    	List<Claim> claims = claimService.getAllClaim();
    	return new ResponseEntity<List<Claim>>(claims, HttpStatus.OK);
	}

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/manulife/claim/{claimid}", method = RequestMethod.GET)
    public ResponseEntity<?> getClaim(@PathVariable("claimid") String claimid,@RequestHeader(value = "tokenID", required = true) String tokenID,@RequestHeader(value = "clientID", required = true) String clientID,@RequestHeader(value = "sessionID", required = true)String sessionID ) {
    	
    	if (sessionID.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Invalid Session ID # " + sessionID 
					), HttpStatus.NOT_FOUND);
		}
		
		if (!sessionID.equals(ClaimConstants.SESSION_ID)) {
			return new ResponseEntity(new CustomErrorType("Invalid Session ID # " + sessionID 
					), HttpStatus.NOT_FOUND);
		}
    	
    	if (clientID.isEmpty()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Clinet ID# " + clientID 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
    	
    	if (!clientID.equals(ClaimConstants.CLIENT_ID)) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Clinet ID# " + clientID 
					+ " is wrong"), HttpStatus.NOT_FOUND);
		}
    	    	
    	if (tokenID.isEmpty()) {
		return new ResponseEntity(new CustomErrorType("TokenID ID# " + tokenID 
				+ " not found"), HttpStatus.NOT_FOUND);
    	}
    	
    	if (!tokenID.equals(ClaimConstants.AUTH_ID)) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Clinet ID# " + tokenID 
					+ " is wrong"), HttpStatus.NOT_FOUND);
		}
    	
    	if (claimid.isEmpty()) {
    		return new ResponseEntity(new CustomErrorType("claimid ID# " + claimid 
    				+ " not found"), HttpStatus.NOT_FOUND);
        }
    	    	
    	Claim claim = claimService.getClaimById(claimid);
    
    	if (validateClaimId(claim, claimid)) {
    		return new ResponseEntity<Claim>(claim, HttpStatus.OK);
	}
	
    	return new ResponseEntity(new CustomErrorType("M2002","The claim number #" + claimid 
					+ " not found"), HttpStatus.NOT_FOUND);
	}
    
    public boolean validateClaimId(Claim claim, String claimId) {
    	if(claim == null) {
    		return false;
    	}
    	return claim.getClaimId().equals(claimId);
    }
}


