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
import com.ElectronicVotingSystem.model.UserType;
import com.ElectronicVotingSystem.repository.UserRepository;
import com.ElectronicVotingSystem.repository.UserTypeRepository;

import lombok.Data;

@Data
class GetUserAndRole{
	private Long userId;
	private String role;
	
	public void setUserId(Long id) {
		this.userId = id;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public String getRole() {
		return this.role;
	}
}

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	private UserTypeRepository userTypeRepository;
	
	@GetMapping("/all")
	public List<UserProfile> getAllUser(){
		return userRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserProfile> getUserById(@PathVariable long id){
		UserProfile user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User does not exist with this id: "+id));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/user/create")
	public ResponseEntity<UserProfile> createUser(@RequestBody UserProfile user) {
		userRepository.save(user);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/role/create")
	public ResponseEntity<UserType> createRole(@RequestBody UserType role){
		userTypeRepository.save(role);
		return ResponseEntity.ok().body(role);
	}
	
	@PostMapping("/user/role")
	public ResponseEntity<String> addRoleToUser(@RequestBody GetUserAndRole getUserAndRole){
		Long userId = getUserAndRole.getUserId();
		UserProfile user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User does not exist with this id: "+userId));
		UserType userType = userTypeRepository.findByType(getUserAndRole.getRole());
		user.getRole().add(userType);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id){
		UserProfile userProfile = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Does not exist with this id: "+id));
		userRepository.delete(userProfile);
		return ResponseEntity.noContent().build();
	}

}


// Create Admin panel because they carry more priorities and need to be designed first and then Electoral officer and then User/Voter
// We have to complete 50% by the end of this week please start working
