package com.myproject.product.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("/")
	public ModelAndView viewHome() {
		return new ModelAndView("home");
	}
	

}
