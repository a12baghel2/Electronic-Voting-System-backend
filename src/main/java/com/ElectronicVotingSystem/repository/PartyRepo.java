package com.ElectronicVotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElectronicVotingSystem.model.Party;

@Repository
public interface PartyRepo extends JpaRepository<Party, Long> {
	Party findByPartyName(String name);
}
