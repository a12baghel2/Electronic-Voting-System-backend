package com.ElectronicVotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ElectronicVotingSystem.model.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

	UserType findByType(String name);

}
