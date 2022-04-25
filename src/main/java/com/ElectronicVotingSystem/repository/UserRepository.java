package com.ElectronicVotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElectronicVotingSystem.model.DAOUser;


@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
	DAOUser findByUsername(String username);

}