package com.ElectronicVotingSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ElectronicVotingSystem.model.Employee;
import com.ElectronicVotingSystem.repository.EmployeeRepository;

@SpringBootApplication
public class ElectronicVotingSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ElectronicVotingSystemApplication.class, args);
	}
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Abhi");
		employee.setLastName("Baghel");
		employee.setEmailId("a12baghel2@gmail.com");
		employeeRepository.save(employee);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Aayushi");
		employee2.setLastName("Sharma");
		employee2.setEmailId("aayushisharma22@gmail.com");
		employeeRepository.save(employee2);
	}

}
