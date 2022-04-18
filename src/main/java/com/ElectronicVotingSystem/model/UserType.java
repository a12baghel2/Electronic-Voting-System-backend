package com.ElectronicVotingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
@Table(name = "usertype")
public class UserType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinTable(name = "user", joinColumns = @JoinColumn (name = "id"))
	private long id;
		@Column(name="userType")
	private String type;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "loginStatus")
	private boolean isLogged;
	
	public void setUserType(String type) {
		this.type = type;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setLoginStatus(boolean status) {
		this.isLogged = status;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public boolean getLoginStatus() {
		return this.isLogged;
	}
	
}
