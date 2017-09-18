package com.manulife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manulife.model.Profile;
import com.manulife.repository.ProfileRepository;

@Service("profileService")
public class ProfileService{
	
	@Autowired
	ProfileRepository profileRepository;
	
	public Profile getProfileByEmail(String email) {
		return profileRepository.findOne(email);
	}
}
