package com.phongt.k18b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phongt.k18b.model.Login;

@Controller
public class LoginController {
	
	@ModelAttribute("loginForm")
	public Login setSignInForm() {
		return new Login();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showLoginForm")
	public String showForm() {
		return "login";
	}
	
	@PostMapping("/checkLoginForm")
	public ModelAndView loginUser(@ModelAttribute("loginForm") Login login) {
		ModelAndView modelAndView = new ModelAndView();
		// Implement business logic to save user details into a database
		//
		if (login.getUserName().equals("admin") && login.getPassword().equals("admin")) {
			modelAndView.setViewName("admin");
			modelAndView.addObject("message", "Thành công");
			modelAndView.addObject("login", login);
			
		} else {
			modelAndView.setViewName("login");
			modelAndView.addObject("message", "Thất bại");
		}

		return modelAndView;
	}
}
