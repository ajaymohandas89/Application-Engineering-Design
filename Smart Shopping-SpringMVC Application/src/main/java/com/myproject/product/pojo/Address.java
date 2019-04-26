package com.myproject.product.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	
	
	public Address() {
	
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long addressId;
	
	private String street;
	private String city;
	private String state;
	private String country;
	private String zip;
	
	@OneToOne(mappedBy="adminAddress",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(mappedBy="customerAddress",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToOne(mappedBy="merchantAddress",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Merchant merchant;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
	
}
