package com.myproject.product.controller;

import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.myproject.product.dao.CategoryDAO;
import com.myproject.product.dao.UserDAO;
import com.myproject.product.exception.ProductException;
import com.myproject.product.exception.UserException;
import com.myproject.product.pojo.Category;
import com.myproject.product.pojo.Feedback;
import com.myproject.product.pojo.Merchant;
import com.myproject.product.pojo.Product;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@RequestMapping(value = "/merchantCont.htm", method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, ModelMap model, Product product) throws ProductException, UserException {
		Merchant productMerchant = null;
		//to print feedback for a given merchant
		List<String> feed = new ArrayList<>();
		List<String>prod = new ArrayList<>();
		HttpSession session = request.getSession();
		//to get all the feedbacks of a particular product
		String merchantName = (String)session.getAttribute("merchantName");
		for(Merchant m:categoryDao.mercList()) {
			if(m.getMerchantUserName().equals(merchantName)) {
				productMerchant = m;
				break;
			}
		}
		for(Product p:categoryDao.allProdList()) {
			Set<Merchant> merchantSet = new HashSet<>();
			merchantSet = p.getMerchant();
			for(Merchant m:merchantSet) {
				if(m.equals(productMerchant)) {
					Set<Feedback> fee = p.getFeedback();
					for(Feedback f:fee) {
						prod.add(p.getProdName());
						feed.add(f.getFeedBack());
						}
				}
			}
		}
		session.setAttribute("Feedbacks", feed);
		session.setAttribute("Product",prod);
		//to set category while adding a product
		session.setAttribute("categoryList", categoryDao.catList());
		return "merchantViewPage";
	}
	
	//to disallow spring to bind the category object
	@InitBinder
	public void customBinding(WebDataBinder binder) {
	    binder.setDisallowedFields(new String[] {"category"});
		
	}
	
	//to create new product
	@RequestMapping(value = "/merchantCont.htm", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Product product,HttpServletRequest req,ModelMap model,HttpSession session) throws ServletException, ProductException, UserException{
		ModelAndView mv=null;
		Category productCategory = null;
		Merchant productMerchant = null;
		
		//Setting the category of the product
		String categoryName = req.getParameter("categoryName");
		for(Category c:categoryDao.catList()) {
			if(c.getCategoryName().equals(categoryName)) {
				productCategory = c;
				break;
			}
		}
		product.setCategory(productCategory);
		
		//setting Merchant of the new product
		String merchantName = (String)session.getAttribute("merchantName");
		for(Merchant m:categoryDao.mercList()) {
			if(m.getMerchantUserName().equals(merchantName)) {
				productMerchant = m;
				break;
			}
		}
		Set merchantSet = new HashSet<>();
		Set productSet = new HashSet<>();
		productSet.add(product);
		merchantSet.add(productMerchant);
		productMerchant.setProduct(productSet);
		product.setMerchant(merchantSet);
		
		//setting the photo of the product
		String localPath = "C:\\Users\\Welcome\\Desktop\\FinalProject_ProductFiles";
		String photoNewName = generateFileName(product.getPhoto());
		product.setProdImage(photoNewName);
		try {
			product.getPhoto().transferTo(new File(localPath,photoNewName));		
		}catch(Exception e) {
			
			
		}

		try {
			int flag = categoryDao.createProduct(product);
			if (flag==1) {
				return new ModelAndView("productaddedsuccessfully");
			}
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String generateFileName(MultipartFile multipart) {
		
		return new Date().getTime() + "-"+multipart.getOriginalFilename().replace(" ", "-");
	}
	
	//to display product form for updating
	@RequestMapping(value = "/merchantUpdate.htm", method = RequestMethod.GET)
	public ModelAndView updateProductForm(HttpServletRequest req, HttpServletResponse resp,HttpSession session,Product product) throws ServletException, UserException{
		ModelAndView mv=null;
		Product selectedProduct = null;
		String productName = req.getParameter("productName");
		//Only allowing owner to edit his own hotel
		String merchant = (String)session.getAttribute("merchantName");
		Merchant owner = null;
		for(Merchant merch:categoryDao.mercList()) {
			if(merch.getMerchantUserName().equals(merchant)) {
				owner = merch;
				break;
			}
		}
		Set<Product> hotelsOfSelectedOwner = owner.getProduct();
		for(Product p:hotelsOfSelectedOwner) {
			if(!(p.getProdName().equalsIgnoreCase(productName))) {
				return new ModelAndView("merchantViewPage");
			}
		}
		
		try {
			List<Product> prod = new ArrayList<Product>();
			prod =  categoryDao.productDetails(productName);
			if(prod.isEmpty()) {
				return new ModelAndView("merchantViewPage");
			}
			for(Product p:prod) {
				if(p.getProdName().equalsIgnoreCase(productName)) {
					selectedProduct = p;
					break;
				}else {
					return new ModelAndView("merchantViewPage");
				}
			}
			session = req.getSession();
			session.setAttribute("product", selectedProduct);
			return new ModelAndView("updateproduct");
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	//to update the product as given by merchant
	@RequestMapping(value = "/merchantUpdate.htm", method = RequestMethod.POST)
	public ModelAndView updateProduct(Product product,HttpServletRequest req,ModelMap model, HttpSession session) throws ServletException{
		ModelAndView mv=null;
		product = (Product) session.getAttribute("product");
		//product.setProdName(req.getParameter("name"));
		product.setProdPrice(req.getParameter("price"));
		product.setProdDecript(req.getParameter("desc"));
		product.setProdQty(Integer.parseInt(req.getParameter("quantity")));
		
		try {
			int flag = categoryDao.updateProduct(product);
			if (flag==1) {
				return new ModelAndView("merchantViewPage");
			}
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
