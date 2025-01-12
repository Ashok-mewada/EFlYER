package com.eflyer.bean;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	private String name;
	private String userName;
	private String email;
	private String password;
	private String userAddress;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userID, String name, String userName, String email, String password, String userAddress) {
		super();
		this.userID = userID;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.userAddress = userAddress;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", userAddress=" + userAddress + "]";
	}
	
	


}
