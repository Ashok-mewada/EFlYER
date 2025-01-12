package com.eflyer.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Admin extends User{
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Product> adminProducts;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int userID, String name, String userName, String email, String password, String userAddress) {
		super(userID, name, userName, email, password, userAddress);
		// TODO Auto-generated constructor stub
	}

	public Admin(List<Product> adminProducts) {
		super();
		this.adminProducts = adminProducts;
	}

	public List<Product> getAdminProducts() {
		return adminProducts;
	}

	public void setAdminProducts(List<Product> adminProducts) {
		this.adminProducts = adminProducts;
	}

	@Override
	public String toString() {
		return "Admin [adminProducts=" + adminProducts + "]";
	}
	
	
}
