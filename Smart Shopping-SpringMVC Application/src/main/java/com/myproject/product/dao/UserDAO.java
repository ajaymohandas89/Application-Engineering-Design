package com.myproject.product.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.mindrot.jbcrypt.BCrypt;

import com.myproject.product.pojo.*;
import com.myproject.product.exception.UserException;

public class UserDAO extends DAO {
	//Declaring a default constructor
	public UserDAO(){	
	}
	
	//Admin registration
	public int registerAdmin(Admin admin) throws UserException {
		int register = 0;
		try {
			begin();
			getSession().save(admin);
			commit();
			register =1;
			return register;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	//Customer registration
	public int registerCustomer(Customer customer) throws UserException {
		int register = 0;
		try {
			begin();
			getSession().save(customer);
			commit();
			register =1;
			return register;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	//Merchant registration
		public int registerMerchant(Merchant merchant) throws UserException {
			int register = 0;
			try {
				begin();
				getSession().save(merchant);
				commit();
				register =1;
				return register;
			} catch (HibernateException e) {
				rollback();
				throw new UserException("Exception while creating user: " + e.getMessage());
			}
		}
		
	//Authenticate User
		
		public String authenticateUser(String username, String password) throws UserException{
			String result = "notAUser";
			
			begin();
			if (username.startsWith("merc")) {
				Merchant merch = null;
				Query query = getSession().getNamedQuery("authenticateMerchant");
				query.setParameter("username", username);
				//query.setParameter("password", password);
				merch = (Merchant) query.uniqueResult();
				if (merch == null || !BCrypt.checkpw(password, merch.getPassword()))
					return result;
				else {
					result = username;
				}
					
			}
			
			else if (username.startsWith("cust")) {
				Query query = getSession().getNamedQuery("authenticateCustomer");
				query.setParameter("username", username);
				//query.setParameter("password", password);
				Customer cust = (Customer) query.uniqueResult();
				
				if (cust == null || !BCrypt.checkpw(password, cust.getPassword()))
					return result;
				else {
					result = username;
					cust.setVisitCount(cust.getVisitCount()+1);
				}
					
			}
			
			else {
				Query query = getSession().getNamedQuery("authenticateAdmin");
				query.setParameter("username", username);
				query.setParameter("password", password);
				Admin admin = (Admin) query.uniqueResult();
				
				if (admin == null)
					return result;
				else {
					result = username;
				}
			}
			
			commit();
			return result;
			
		}
		
		//Get all list of users
		public List<Customer> custList() throws UserException {
			try {
				begin();
				Query q = getSession().createQuery("from Customer");
				List<Customer> list = q.list();
				commit();
				return list;
			} catch (HibernateException e) {
				rollback();
				throw new UserException("Could not list the Customer", e);
			}
		} 
		
		//Get all list of merchant
				public List<Merchant> merchList() throws UserException {
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
		//Get detail of a merchant
				public List<Merchant> merchDetails(String merchName) throws UserException {
					try {
						begin();
						Criteria mercDetail = getSession().createCriteria(Merchant.class);
						Criterion merchFName = Restrictions.like("firstName",merchName);
						Criterion merchLName = Restrictions.like("lastName",merchName);
						Criterion merchUserName = Restrictions.like("merchantUserName",merchName);
						Disjunction orExp = Restrictions.disjunction();
						orExp.add(merchFName);orExp.add(merchLName);orExp.add(merchUserName);
						mercDetail.add(orExp);
						List<Merchant> list = mercDetail.list();
						commit();
						return list;
					} catch (HibernateException e) {
						rollback();
						throw new UserException("Could not list the Merchant", e);
					}
			}
			
		//Get detail of a users
				public List<Customer> userDetails(String userName) throws UserException {
					try {
						begin();
						Criteria userDetail = getSession().createCriteria(Customer.class);
						Criterion custFName = Restrictions.like("firstName",userName);
						Criterion custLName = Restrictions.like("lastName",userName);
						Criterion custUserName = Restrictions.like("custUserName",userName);
						Disjunction orExp = Restrictions.disjunction();
						orExp.add(custFName);orExp.add(custLName);orExp.add(custUserName);
						userDetail.add(orExp);
						List<Customer> list = userDetail.list();
						commit();
						return list;
					} catch (HibernateException e) {
						rollback();
						throw new UserException("Could not list the Customer", e);
					}
			}
		
				//Get customer details
				public Customer getCustDetail(String custName) throws UserException {
					try {
						begin();
						Criteria crit = getSession().createCriteria(Customer.class);
						
						Criterion userName = Restrictions.eq("custUserName",custName);
						crit.add(userName);
						Customer cust = (Customer) crit.uniqueResult();
						commit();
						return cust;
					} catch (HibernateException e) {
						rollback();
						throw new UserException("Could not list the Customer", e);
					}
				} 
		
}	
