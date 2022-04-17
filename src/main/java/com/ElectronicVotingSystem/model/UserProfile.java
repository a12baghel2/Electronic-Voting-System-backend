package com.ElectronicVotingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "presentAddress")
	private String presentAddress;
	
	@Column(name = "permanentAddress")
	private String permanentAddress;
	
	@Column(name = "phoneNumber")
	private long phoneNumber;
	
	@Column(name = "emailId")
	private String emailId;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setPresentAddress(String address) {
		this.presentAddress = address;
	}
	
	public void setPermanentAddress(String address) {
		this.permanentAddress = address;
	}
	
	public void setPhoneNumber(long num) {
		this.phoneNumber = num;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDob() {
		return this.dob;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public String getPresentAddress() {
		return this.presentAddress;
	}
	
	public String getPermanentAddress() {
		return this.permanentAddress;
	}
	
	public String getEmailId() {
		return this.emailId;
	}
	
	public long getPhoneNumber() {
		return this.phoneNumber;
	}
}
	