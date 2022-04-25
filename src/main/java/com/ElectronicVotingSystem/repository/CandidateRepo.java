package com.ElectronicVotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElectronicVotingSystem.model.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Long> {
	Candidate findByName(String name);
	Candidate findByPartyName(String partyName);
}