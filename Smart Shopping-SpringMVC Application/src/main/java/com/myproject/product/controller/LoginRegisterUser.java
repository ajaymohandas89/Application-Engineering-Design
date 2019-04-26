package com.myproject.product.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.apache.commons.mail.*;
import com.myproject.product.dao.UserDAO;
import com.myproject.product.exception.UserException;
import com.myproject.product.pojo.*;
@Controller
@RequestMapping("/")
public class LoginRegisterUser {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		ModelAndView mv=null;
		
		String user = req.getParameter("username");
		String pswd = req.getParameter("password");
		
		try {
			String checkValidUser = userDao.authenticateUser(user, pswd);
			
			if (checkValidUser.startsWith("admin"))
				mv = new ModelAndView(new RedirectView("admin/completeInfo.htm",false));
			else if (checkValidUser.startsWith("merc")) {
				HttpSession session = req.getSession();
				session.setAttribute("merchantName",user);
				mv = new ModelAndView(new RedirectView("merchant/merchantCont.htm",false));}
			else if (checkValidUser.startsWith("cust"))
			{
				HttpSession session = req.getSession();
				session.setAttribute("customerUserName",user);
				mv = new ModelAndView(new RedirectView("customer/categoryList.htm",false));
				}
			else if (checkValidUser.equalsIgnoreCase("notAUser"))
				mv = new ModelAndView("registerUser");
			
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest req, HttpServletResponse resp) throws UserException{
		ModelAndView mv=null;
		
		String pswd = req.getParameter("password");
		String confirmpswd = req.getParameter("confirmpassword");
		
		if (pswd.equals(confirmpswd)) {
			String fName = req.getParameter("firstName");
			String lName = req.getParameter("lastName");
			String emailId = req.getParameter("emailId");
			String street = req.getParameter("street");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String zip = req.getParameter("zip");
			String country = req.getParameter("Country");
			long primaryContact = Long.parseLong(req.getParameter("primePhone"));
			long secContatc = Long.parseLong(req.getParameter("secondPhone"));
			String username = req.getParameter("username");
			
			Address address = new Address();
			address.setStreet(street);
			address.setCity(city);
			address.setState(state);
			address.setZip(zip);
			address.setCountry(country);
			
			/*Set<Phone> ph = new HashSet<Phone>();
			ph.add(new Phone(primaryContact));
			ph.add(new Phone(secContatc));*/
			
			String hashedPswd = BCrypt.hashpw(pswd, BCrypt.gensalt());
			
			String userType = req.getParameter("usertype");
			
			if (userType.equalsIgnoreCase("Merchant"))
			{
				Merchant merch = new Merchant();
				merch.setFirstName(fName);
				merch.setLastName(lName);
				merch.setEmailId(emailId);
				merch.setMerchantUserName("merc"+username);
				merch.setMerchantAddress(address);
				//merch.setContact(ph);
				merch.setPassword(hashedPswd);
				
				int flag = userDao.registerMerchant(merch);
				try {
					SendEmail("ajaymohandas89@gmail.com",merch.getMerchantUserName());
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (flag==1)
				mv = new ModelAndView("home");
			}else if (userType.equalsIgnoreCase("Customer")) 
				{
					Customer cust = new Customer();
					cust.setFirstName(fName);
					cust.setLastName(lName);
					cust.setEmailId(emailId);
					cust.setCustUserName("cust"+username);
					cust.setCustomerAddress(address);
					//cust.setContact(ph);
					cust.setPassword(hashedPswd);
					cust.setVisitCount(0);
					
					int flag = userDao.registerCustomer(cust);
					try {
						SendEmail("ajaymohandas89@gmail.com",cust.getCustUserName());
					} catch (EmailException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (flag==1)
						mv = new ModelAndView("home");
				}
			

		}else {
			mv = new ModelAndView("errorRegister");
		}
		
		return mv;
	}
	
	public void SendEmail(String emailID,String username) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		//User your gmail username and password
		email.setAuthenticator(new DefaultAuthenticator("ajaytestDev@gmail.com", "qwerty123M"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@msis.neu.edu");
		email.setSubject("TestMail");
		email.setMsg("Registered successfully	"+" Your username is	"+ username);
		email.addTo(emailID);
		email.send();
	}
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/newRegisterUser", method = RequestMethod.GET)
	public ModelAndView newUserRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		return new ModelAndView("registerUser");
		
	}

}
