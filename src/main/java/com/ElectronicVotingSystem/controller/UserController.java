package com.ElectronicVotingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElectronicVotingSystem.model.Candidate;
import com.ElectronicVotingSystem.model.Election;
import com.ElectronicVotingSystem.model.Party;
import com.ElectronicVotingSystem.repository.CandidateRepo;
import com.ElectronicVotingSystem.repository.ElectionRepo;
import com.ElectronicVotingSystem.repository.PartyRepo;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class UserController {
	
	@Autowired
	private PartyRepo partyRepo;
	
	@Autowired
	private CandidateRepo candidateRepo;
	
	@Autowired
	private ElectionRepo electionRepo;
	
	@PostMapping("/add/election")
	public Election addElection(@RequestBody Election election) {
		return electionRepo.save(election);
	}
	
	@GetMapping("/upcoming")
	public List<Election> getUpcomingElection(){
		return electionRepo.findAll();
	}
	
	@PostMapping("/add/party")
	public Party addPartyDeatils(@RequestBody Party party) {
		return partyRepo.save(party);
	}
	
	@GetMapping("/view/party")
	public List<Party> getPartyDetail(){
		return partyRepo.findAll();
	}
	
	@PostMapping("/assign/candidate")
	public Candidate addCandidateToElection(@RequestBody Candidate candidate) {
		return candidateRepo.save(candidate);
	}
	
	@GetMapping("/detail/candidate/all")
	public List<Candidate> getAllCandidate(){
		return candidateRepo.findAll();
	}
	
	@GetMapping("/detail/candidate/{name}")
	public Candidate getParticularCandidate(@PathVariable String name){
		return candidateRepo.findByName(name);
	}
	
}

