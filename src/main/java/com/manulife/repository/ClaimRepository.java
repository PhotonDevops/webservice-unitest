package com.manulife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manulife.model.Claim;

@Repository("claimRepository")
public interface ClaimRepository extends JpaRepository<Claim, String> {
}
