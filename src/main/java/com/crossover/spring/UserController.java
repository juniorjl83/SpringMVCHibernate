package com.crossover.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossover.spring.model.Person;
import com.crossover.spring.service.UserService;
import com.crossover.spring.viewBean.LoginBean;

@Controller
public class UserController {

	@Autowired(required = true)
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value =  "/users", method = RequestMethod.GET)
	public String showLogin(Model model) {

		logger.debug("UserController.usersIndexHandler is invoked.");
		model.addAttribute("loginBean", new LoginBean());
		
		return "user";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String isValidUser(@ModelAttribute("loginBean") LoginBean model) {
		
		boolean isValidUser = userService.isValidUser(model.getUsername(), model.getPassword());
		
		if ( isValidUser ){
			logger.debug("is valid User.");
			return "redirect:/tests";
		}else{
			logger.debug("is invalid User.");
			model.setPassword("");
			model.setMessage("Invalid credentials!!.");
		}
		
		return "user";
	}
	
	
}
