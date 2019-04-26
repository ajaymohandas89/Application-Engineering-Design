package com.myproject.product.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.product.dao.CategoryDAO;
import com.myproject.product.dao.UserDAO;
import com.myproject.product.exception.ProductException;
import com.myproject.product.exception.UserException;
import com.myproject.product.pojo.Category;
import com.myproject.product.pojo.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	//home page for admin
	@RequestMapping(value = "/completeInfo.htm", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request, ModelMap model, Product product) {
		ModelAndView mv=null;
		HttpSession session = request.getSession();
		//getting all the category list
		try {
			session.setAttribute("categoryList", categoryDao.catList() );
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			session.setAttribute("curtomerList", userDao.custList());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			session.setAttribute("merchantList", userDao.merchList());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv = new ModelAndView("adminPage");
		return mv;	
	
	}
	
	@RequestMapping(value = "/createCategory.htm", method = RequestMethod.POST)
	public ModelAndView createCategory(HttpServletRequest req,ModelMap model, HttpSession session) throws ServletException, ProductException{
		ModelAndView mv=null;
		String catName = req.getParameter("categoryName");
		
		List<Category> categoryList= categoryDao.catList();
		for (Category ctemp: categoryList) {
			if (ctemp.getCategoryName().equalsIgnoreCase(catName)) {
				System.out.println("test cat");
				return new ModelAndView("adminError");
			}
				
		}
		
		Category c = new Category();
		c.setCategoryName(catName);
		c.setCategoryDescript(req.getParameter("categoryDesc"));

		
		try {
			int flag = categoryDao.createCategory(c);
			if (flag==1) {
				return new ModelAndView("adminPage");
			}
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("adminPage");
	}
	

}
