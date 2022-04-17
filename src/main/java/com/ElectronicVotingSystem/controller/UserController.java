package com.ElectronicVotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElectronicVotingSystem.model.UserProfile;
import com.ElectronicVotingSystem.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<UserProfile> getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping
	public UserProfile createUser(@RequestBody UserProfile user) {
		return userRepository.save(user);
	}

}
