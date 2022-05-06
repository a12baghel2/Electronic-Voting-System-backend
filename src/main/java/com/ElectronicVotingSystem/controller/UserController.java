package com.ElectronicVotingSystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElectronicVotingSystem.configuration.JwtUtil;
import com.ElectronicVotingSystem.model.Candidate;
import com.ElectronicVotingSystem.model.DAOUser;
import com.ElectronicVotingSystem.model.VoterId;
import com.ElectronicVotingSystem.repository.CandidateRepo;
import com.ElectronicVotingSystem.repository.UserRepository;
import com.ElectronicVotingSystem.repository.VoterIdRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private VoterIdRepo voterIdRepo;
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@PostMapping("/voterid/requested")
	public ResponseEntity<?> requestedVoterId( HttpServletRequest request, HttpServletResponse response){
		String username = getUsername(request, response);
		String name = userRepository.findByUsername(username).getName();
		VoterId voterId = new VoterId(); 
		voterId.setName(name);
		voterId.setIsRequested(true);
		voterIdRepo.save(voterId);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/castvote/{name}")
	public boolean castVote(@PathVariable String name) {
		System.out.print(name);
		Candidate candidate = candidateRepo.findBycandidateName(name);
		candidate.setVoteCount();
		candidateRepo.save(candidate);
		return true;
	}
	
	@GetMapping("/voterid")
	public long getVoterId(HttpServletRequest request, HttpServletResponse response) {
		String username = getUsername(request, response);
		String name = userRepository.findByUsername(username).getName();
		return voterIdRepo.findByName(name).getId();
	}
	
	@GetMapping("/result")
	public List<Candidate> getResult() {
		List<Candidate> list = candidateRepo.findByOrderByVoteCountDesc();
		return list;
	}
	
	@PutMapping("/resetpass")
	public boolean updatePassword(@RequestBody String password, HttpServletRequest request, HttpServletResponse response) {
		String username = getUsername(request, response);
		DAOUser user = userRepository.findByUsername(username);
		user.setPassword(bcryptEncoder.encode(password));
		userRepository.save(user);
		return true;
	}
	
	private String getUsername(HttpServletRequest request, HttpServletResponse response) {
		String jwtToken = extractJwtFromRequest(request);
		if (StringUtils.hasText(jwtToken) && jwtTokenUtil.validateToken(jwtToken)) {
			return jwtTokenUtil.getUsernameFromToken(jwtToken);
		}
		return null;
	}
	
	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
}
