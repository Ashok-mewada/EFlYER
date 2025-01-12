package com.eflyer.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eflyer.bean.Admin;
import com.eflyer.bean.Product;
import com.eflyer.bean.User;
import com.eflyer.service.ProductService;
import com.eflyer.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	HttpSession hs = null;
	
	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("Request aa gyi he");
		List<Product> products =  productService.findAll();
		model.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/register")
	public String register1() {
		return "registration";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		System.out.println(user);
		if(user == null)
			return "registration";
		userService.save(user);
		return "index";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		hs = request.getSession(false);
		if(hs!=null)
			hs.invalidate();
		return "login";
	}
	
	@PostMapping("/login")
	public ModelAndView login1(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
		User user = userService.login(username, password);
		if(user == null) {
			System.out.println("Username doesn't exist!!");
			mv.setViewName("redirect:/registration");
			return mv;
		}
			
		if(user instanceof Admin) {
			hs = request.getSession(false);
			if(hs != null) {
				hs.invalidate();
			}
			hs = request.getSession();
			hs.setAttribute("admin", user);
			mv.addObject("admin", user);
			mv.setViewName("redirect:/admin");
			return mv;
		}
		mv.addObject("user", user);
		mv.setViewName("index");
		return mv;
		
	}
}
