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
import javax.persistence.OneToMany;


@Entity
public class Category {
	
	
	public Category() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long categoryId;
	
	private String categoryName;
	private String categoryDescript;
	
	@OneToMany(mappedBy="category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name="prodId")
	private Set<Product> product;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "category_customer_table", joinColumns = {
			@JoinColumn(name = "categoryID", nullable = false, updatable = false)},
	inverseJoinColumns = {
			@JoinColumn(name ="custId")
	})
	private Set<Customer> customer = new HashSet<Customer>();

	public long getCategoryId() {
		return categoryId;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescript() {
		return categoryDescript;
	}

	public void setCategoryDescript(String categoryDescript) {
		this.categoryDescript = categoryDescript;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
}
