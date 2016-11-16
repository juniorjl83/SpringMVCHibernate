package com.crossover.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crossover.spring.model.ParameterId;
import com.crossover.spring.model.Person;
import com.crossover.spring.service.UserService;
import com.crossover.spring.service.parameterService;
import com.crossover.spring.viewBean.LoginBean;

@Controller
public class UserController {

	@Autowired(required = true)
	private UserService userService;
	
	@Autowired
	private parameterService parameterService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value =  "/users", method = RequestMethod.GET)
	public String showLogin(Model model) {

		logger.debug("UserController.usersIndexHandler is invoked.");
		
		LoginBean loginBean = new LoginBean();
		/*load Description of test from database*/
		loginBean.setDescription(parameterService.get(new ParameterId("description", "1")).getParameterVarchar());
		
		model.addAttribute("loginBean", loginBean);
		
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
			model.setDescription(parameterService.get(new ParameterId("description", "1")).getParameterVarchar());
			model.setPassword("");
			model.setMessage("Invalid credentials!!.");
		}
		
		return "user";
	}
	
	
}
