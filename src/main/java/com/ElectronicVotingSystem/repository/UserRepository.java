package com.ElectronicVotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ElectronicVotingSystem.model.UserProfile;

public interface UserRepository extends JpaRepository<UserProfile, Long>{
	//CRUD operation on Userprofile
}
