package com.myproject.product.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQuery(name="authenticateAdmin", query="from Admin where adminUserName=:username and password=:password")

@Entity
public class Admin {
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long adminId;
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String adminUserName;
	private String password;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Category> category;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Customer> customer;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Merchant> merchant;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="addrssId")
	private Address adminAddress;
	
	//@OneToMany(mappedBy="adminPhone",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Set<Phone> contact;

	public Admin() {
		
	}
	
	
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAdminUserName() {
		return adminUserName;
	}


	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	public Set<Merchant> getMerchant() {
		return merchant;
	}

	public void setMerchant(Set<Merchant> merchant) {
		this.merchant = merchant;
	}

	

	public Address getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(Address adminAddress) {
		this.adminAddress = adminAddress;
	}

	/*public Set<Phone> getContact() {
		return contact;
	}

	public void setContact(Set<Phone> contact) {
		this.contact = contact;
	}*/
	
	

}
