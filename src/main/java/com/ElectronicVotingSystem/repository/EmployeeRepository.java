package com.ElectronicVotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ElectronicVotingSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//All database CRUD operation
}
