package com.manulife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manulife.model.Profile;

@Repository("profileRepository")
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
