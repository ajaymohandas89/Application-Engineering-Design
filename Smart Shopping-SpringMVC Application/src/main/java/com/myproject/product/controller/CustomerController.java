package com.myproject.product.controller;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.myproject.product.dao.CategoryDAO;
import com.myproject.product.dao.UserDAO;
import com.myproject.product.exception.FeedbackException;
import com.myproject.product.exception.ProductException;
import com.myproject.product.exception.UserException;
import com.myproject.product.pojo.Category;
import com.myproject.product.pojo.Customer;
import com.myproject.product.pojo.Feedback;
import com.myproject.product.pojo.Product;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/categoryList.htm", method = RequestMethod.GET)
	public ModelAndView getCategoryList(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
			HttpSession session = req.getSession();
			ModelAndView mv = null;
			try {
				List<Category> catList = categoryDao.catList();
				session.setAttribute("catList", catList);
				mv = new ModelAndView("custViewPage");
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mv;
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public ModelAndView getproductList(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
			
			String selectedCategory = req.getParameter("selectedCategory");
			HttpSession session = req.getSession();
			ModelAndView mv = null;
			try {
				List<Product> prodList = categoryDao.prodList(selectedCategory);
				session.setAttribute("allProdList", prodList);
				session.setAttribute("categoryName", selectedCategory);
				mv = new ModelAndView("productViewPage");
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mv;
	}
	
	@RequestMapping(value = "/prodData", method = RequestMethod.GET)
	public ModelAndView getproductDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
			
			String selectedProduct = req.getParameter("selectedProduct");
			HttpSession session = req.getSession();
			ModelAndView mv = null;
			try {
				Product prodList = categoryDao.productDescript(selectedProduct);
				List<Feedback> feed = categoryDao.getFeedback(selectedProduct);
				session.setAttribute("prodList", prodList);
				session.setAttribute("feedList", feed);
				mv = new ModelAndView("productDescription");
			} catch (ProductException|FeedbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mv;
	}
	
	@RequestMapping(value = "/getPDFView", method = RequestMethod.GET)
	public View getPDFViewProductDetails(HttpServletRequest req, HttpServletResponse resp) {
		
		String selectedCategory = req.getParameter("selectedCategory");
		
		View view = new ProductDetailPDFImpl(categoryDao,selectedCategory);
		return view;

			
	}
	
	@RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
	public ModelAndView addFeedback(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = null;
		Feedback f = new Feedback();
		HttpSession session = req.getSession();
		String feedback = req.getParameter("feedback");
		Product product = (Product) session.getAttribute("prodList");
		String customer = (String)session.getAttribute("customerUserName");
		try {
		Customer cust = userDao.getCustDetail(customer);
		f.setCustomer(cust);
		f.setFeedBack(feedback);
		f.setProduct(product);
		int flag = categoryDao.addFeedBack(f);
		if (flag==1)
			mv = new ModelAndView("productDescription");
		else
			mv = new ModelAndView("errorRegister");
		} catch (UserException|ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
		
		
	}
}
