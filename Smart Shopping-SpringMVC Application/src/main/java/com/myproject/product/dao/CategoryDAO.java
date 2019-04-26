package com.myproject.product.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.myproject.product.pojo.*;
import com.myproject.product.exception.FeedbackException;
import com.myproject.product.exception.ProductException;
import com.myproject.product.exception.UserException;


public class CategoryDAO extends DAO{
	
	public CategoryDAO(){	
	}
	
	//Add new category
	public int createCategory(Category cat) throws ProductException {
		int register = 0;
		try {
			begin();
			getSession().save(cat);
			commit();
			register =1;
			return register;
		} catch (HibernateException e) {
			rollback();
			throw new ProductException("Exception while creating user: " + e.getMessage());
		}
	}
	//Add new Product
	public int createProduct(Product prod) throws ProductException {
		int register = 0;
		try {
			begin();
			getSession().merge(prod);
			commit();
			register =1;
			return register;
		} catch (HibernateException e) {
			rollback();
			throw new ProductException("Exception while creating user: " + e.getMessage());
		}
	}
	
	//List all category
	public List<Category> catList() throws ProductException {
		try {
			begin();
			Query q = getSession().createQuery("from Category");
			List<Category> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new ProductException("Could not list the Category", e);
			}
		} 
	
	//List all products under a category
		public List<Product> prodList(String catName) throws ProductException {
			try {
				begin();
				Criteria prodList = getSession().createCriteria(Product.class);
				Criteria catList = prodList.createCriteria("category");
				catList.add(Restrictions.eq("categoryName",catName));
				
				prodList.addOrder(Order.asc("prodPrice"));
				prodList.addOrder(Order.desc("userViewCount"));
				
				List<Product> result = prodList.list();
				commit();
				return result;
			} catch (HibernateException e) {
				rollback();
				throw new ProductException("Could not list the Catrgory", e);
				}
			}
		//Get detail of a product
		public List<Product> productDetails(String prodName) throws ProductException {
			try {
				begin();
				
				Criteria prodDetail = getSession().createCriteria(Product.class);
				
				Criterion productName = Restrictions.like("prodName",prodName);
				
				prodDetail.add(productName);
				prodDetail.setMaxResults(10);
				List<Product> list = prodDetail.list();
				commit();
				return list;
			} catch (HibernateException e) {
				rollback();
				throw new ProductException("Could not list the Product", e);
			}
	}
		//Update a product
		public int updateProduct(Product prod) throws ProductException {
			int register = 0;
			try {
				begin();
				getSession().merge(prod);
				commit();
				register =1;
				return register;
			} catch (HibernateException e) {
				rollback();
				throw new ProductException("Exception while creating user: " + e.getMessage());
			}
		}
		
		//Get description of one product
				public Product productDescript(String prodName) throws ProductException {
					try {
						begin();
						
						Criteria prodDetail = getSession().createCriteria(Product.class);
						
						Criterion productName = Restrictions.eq("prodName",prodName);
						
						prodDetail.add(productName);
						//prodDetail.setMaxResults(10);
						Product p = (Product) prodDetail.uniqueResult();
						p.setUserViewCount(p.getUserViewCount()+1);
						commit();
						return p;
					} catch (HibernateException e) {
						rollback();
						throw new ProductException("Could not list the Product", e);
					}
		
}
		//Add feedback to a product
				public int addFeedBack(Feedback fd) throws ProductException {
					int register = 0;
					try {
						begin();
						getSession().merge(fd);
						commit();
						register =1;
						return register;
					} catch (HibernateException e) {
						rollback();
						throw new ProductException("Exception while creating user: " + e.getMessage());
					}
				}
			//Get feedback of a product
				public List<Feedback> getFeedback(String selectedProduct) throws FeedbackException {
					try {
						begin();
						Criteria feedList = getSession().createCriteria(Feedback.class);
						Criteria prod = feedList.createCriteria("product");
						prod.add(Restrictions.eq("prodName",selectedProduct));
						
						List<Feedback> result = feedList.list();
						commit();
						return result;
					} catch (HibernateException e) {
						rollback();
						throw new FeedbackException("Exception while creating user: " + e.getMessage());
						}
					}
				
				//List all Products
				public List<Product> allProdList() throws ProductException {
					try {
						begin();
						Query q = getSession().createQuery("from Product");
						List<Product> list = q.list();
						commit();
						return list;
					} catch (HibernateException e) {
						rollback();
						throw new ProductException("Could not list the Merchant", e);
						}
					}
				
				//List all Merchants
				public List<Merchant> mercList() throws UserException {
					try {
						begin();
						Query q = getSession().createQuery("from Merchant");
						List<Merchant> list = q.list();
						commit();
						return list;
					} catch (HibernateException e) {
						rollback();
						throw new UserException("Could not list the Merchant", e);
						}
					}
}
