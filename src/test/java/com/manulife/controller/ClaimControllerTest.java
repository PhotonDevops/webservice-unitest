package com.manulife.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manulife.model.Claim;
import com.manulife.model.Hospital;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClaimControllerTest {
	
	@Autowired
	ClaimController claimController;
	
	@Test
	public void testValidateClaimIdSuccess() {
		Claim claim = new Claim("16080215833", "8282474042", "alexa.sawyer@gmail.com", "Alexa Sawyer", "Processed", "02/24/2017", "02/24/2017", "$210", "$210", new Hospital("Union Hospital", "659 Boulevard St", "Dover", "Ohio", "44622", "United States"));
		assertTrue(claimController.validateClaimId(claim, "16080215833"));
	}

}
