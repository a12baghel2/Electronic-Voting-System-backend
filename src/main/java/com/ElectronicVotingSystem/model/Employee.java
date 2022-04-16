package com.ElectronicVotingSystem.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Getter
	@Setter
	@Column(name = "first_name")
	private String firstName;
	

	@Column(name = "last_name")
	private String lastName;
	

	@Column(name = "email_id")
	private String emailId;

	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getEmailId() {
		return this.emailId;
	}
	
	public void setFirstName(String string) {
		// TODO Auto-generated method stub
		this.firstName = string;
		
	}

	public void setEmailId(String string) {
		// TODO Auto-generated method stub
		this.emailId = string;
		
	}

	public void setLastName(String string) {
		// TODO Auto-generated method stub
		this.lastName = string;
		
	}
}
