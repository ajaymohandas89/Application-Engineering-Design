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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	public Product() {

	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long prodId;
	
	private String prodName;
	private String prodPrice;
	private String prodImage;
	@Transient
	private MultipartFile photo;
	private String prodDecript;
	private int prodQty;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "Product_Merchant_table", joinColumns = {
			@JoinColumn(name = "prodId", nullable = false, updatable = false)
			},
	inverseJoinColumns = {
			@JoinColumn(name ="merchantId")
	})
	private Set<Merchant> merchant = new HashSet<Merchant>();
	
	@OneToMany(mappedBy="product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Feedback> feedback;
	
	private int userViewCount;

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	
	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public String getProdDecript() {
		return prodDecript;
	}

	public void setProdDecript(String prodDecript) {
		this.prodDecript = prodDecript;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	public Set<Merchant> getMerchant() {
		return merchant;
	}

	public void setMerchant(Set<Merchant> merchant) {
		this.merchant = merchant;
	}

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

	public int getUserViewCount() {
		return userViewCount;
	}

	public void setUserViewCount(int userViewCount) {
		this.userViewCount = userViewCount;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
}
