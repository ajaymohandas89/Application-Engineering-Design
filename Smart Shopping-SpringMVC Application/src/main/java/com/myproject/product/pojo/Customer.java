package com.myproject.product.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@NamedQuery(name="authenticateCustomer", query="from Customer where custUserName=:username")

@Entity
public class Customer {
	
	
	public Customer() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long custId;
	
	private String firstName;
	private String lastName;
	private int visitCount;
	private String emailId;
	private String custUserName;
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="addrssId")
	private Address customerAddress;
	
	//@OneToMany(mappedBy="customerPhone",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Set<Phone> contact;
	
	@ManyToMany(mappedBy="customer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Category> category;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}
	
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustUserName() {
		return custUserName;
	}

	public void setCustUserName(String custUserName) {
		this.custUserName = custUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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



	

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	/*public Set<Phone> getContact() {
		return contact;
	}

	public void setContact(Set<Phone> contact) {
		this.contact = contact;
	}*/

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
	
	
}
