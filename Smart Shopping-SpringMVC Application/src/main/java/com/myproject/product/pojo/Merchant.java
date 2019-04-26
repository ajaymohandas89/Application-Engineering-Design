package com.myproject.product.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@NamedQuery(name="authenticateMerchant", query="from Merchant where merchantUserName=:username")

@Entity
public class Merchant {
	
	public Merchant() {
	
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long merchantId;
	
	private String firstName;
	private String lastName;
	private String emailId;
	private String merchantUserName;
	private String password;
	
	@ManyToMany(mappedBy="merchant",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Product> product = new HashSet<Product>();;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="addrssId")
	private Address merchantAddress;
	
	//@OneToMany(mappedBy="merchantPhone",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Set<Phone> contact;

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
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
	
	
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMerchantUserName() {
		return merchantUserName;
	}

	public void setMerchantUserName(String merchantUserName) {
		this.merchantUserName = merchantUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	

	public Address getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(Address merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	/*public Set<Phone> getContact() {
		return contact;
	}

	public void setContact(Set<Phone> contact) {
		this.contact = contact;
	}*/
	
	
}
