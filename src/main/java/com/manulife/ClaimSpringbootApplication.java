package com.manulife;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.manulife.model.Claim;
import com.manulife.model.Credential;
import com.manulife.model.Hospital;
import com.manulife.model.Profile;
import com.manulife.repository.ClaimRepository;
import com.manulife.repository.CredentialRepository;
import com.manulife.repository.ProfileRepository;

@SpringBootApplication
public class ClaimSpringbootApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ClaimSpringbootApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ClaimSpringbootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(CredentialRepository credentialRepository, ClaimRepository claimRepository, ProfileRepository profileRepository) {
		return (args) -> {

			// Dummy data for credential
			credentialRepository.save(new Credential("alexa.sawyer@gmail.com", "ABC123abc"));
			credentialRepository.save(new Credential("admin@gmail.com", "qwe123"));

			// Dummy data for profile
			profileRepository.save(new Profile("alexa.sawyer@gmail.com", "Alexa", "Sawyer", "08/01/1974", "302-2951 Ipsum. Road", "Lowell", "Massachusetts", "US", "49235", "(128) 858-2131"));
			
			// Dummy data for claim details
			claimRepository.save(new Claim("16080215833", "8282474042", "alexa.sawyer@gmail.com", "Alexa Sawyer", "Processed", "02/24/2017", "02/24/2017", "$210", "$210", new Hospital("Union Hospital", "659 Boulevard St", "Dover", "Ohio", "44622", "United States")));
			claimRepository.save(new Claim("16170321000", "8282727332", "alexa.sawyer@gmail.com", "Alexa Sawyer", "In-Progress", "03/01/2017", "03/15/2017", "$670", "$500", new Hospital("Northwestern Memorial Hospital", "251 E Huron St", "Chicago", "Illinois", "60611", "United States")));
			
			logger.info("The sample data has been generated");

		};
	}
}
