package com.manulife.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manulife.constant.ClaimConstants;
import com.manulife.model.Credential;
import com.manulife.model.Profile;
import com.manulife.service.LoginService;
import com.manulife.service.ProfileService;
import com.manulife.util.CustomErrorType;

@CrossOrigin("http://manulife-claim-dockermgmt.centralus.cloudapp.azure.com:5050")
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private ProfileService profileService;
	
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Credential loginReq) {
    	    	if(loginReq.getEmail().isEmpty() || loginReq.getPassword().isEmpty()) {
	    		return new ResponseEntity(new CustomErrorType("M1001", "Please check your email and password"), HttpStatus.NOT_FOUND);
	    	}
    	    	
	    Credential credential = loginService.getCredentialByEmail(loginReq.getEmail());
	    if(validateCredential(credential, loginReq)) {
	    		Profile profile = profileService.getProfileByEmail(credential.getEmail());
	    		profile.setSessionId(ClaimConstants.SESSION_ID);
    			return new ResponseEntity<>(profile, HttpStatus.OK);
	    	}
	    	return new ResponseEntity(new CustomErrorType("M1001", "Please check your email and password"), HttpStatus.NOT_FOUND);	
	}
    
    public boolean validateCredential(Credential credential, Credential loginReq) {
    		if(credential == null) {
    			return false;
    		}
    		return (loginReq.getEmail().equals(credential.getEmail()) && loginReq.getPassword().equals(credential.getPassword()));
    }
}


