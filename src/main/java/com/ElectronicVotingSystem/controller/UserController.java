package com.ElectronicVotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElectronicVotingSystem.exception.ResourceNotFoundException;
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
	
	@GetMapping("{id}")
	public ResponseEntity<UserProfile> getUserById(@PathVariable long id){
		UserProfile user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not exist with this id"));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public UserProfile createUser(@RequestBody UserProfile user) {
		return userRepository.save(user);
	}
	

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id){
		UserProfile userProfile = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Does not exist with this id"));
		userRepository.delete(userProfile);
		return ResponseEntity.noContent().build();
	}

}

// Create Admin panel because they carry more priorities and need to be designed first and then Electoral officer and then User/Voter
// We have to complete 50% by the end of this week please start working
