package com.ElectronicVotingSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ElectronicVotingSystem.model.UserProfile;

public interface UserRepository extends JpaRepository<UserProfile, Long>{
	Optional<UserProfile> findUserById(Long userId); 
	UserProfile findByEmail(String email);
}
