package com.ElectronicVotingSystem.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "User")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<UserType> role = new ArrayList<>();
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setRole(ArrayList<UserType> role) {
		this.role = role;
	}
	
	public Collection<UserType> getRole() {
		return this.role;
	}
	
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
	