package com.datasheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.datasheet.model.User;
import com.datasheet.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userSvc;
	
	@RequestMapping(params = "register", method=RequestMethod.POST)
	public String registerUser( Model model,
								@RequestParam("username") String name,
							    @RequestParam("password") String password,
							    @RequestParam("email") String email){
							
		
		if(  (userSvc.getUserByName(name) == null)
		  && (name != null) 
		  && (password != null)
		  && (email!= null)) {
				User user = new User(name, password, email);
				userSvc.addUser(user);
			
				return "redirect:/login";
		}
		else{
			model.addAttribute("error", "Username is already taken or form blank");
			return "register.jsp";
		}
	}
	
	@RequestMapping(value ="/registration", method = RequestMethod.POST)
	public String showRegistrationForm() {
	    return "register.jsp";
	}
	
	@RequestMapping(value ="/login", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(@RequestParam(value = "error", 
	                          required = false) String error,
		                      @RequestParam(value = "logout", 
		                      required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Please check username and password");
	  }

	  if (logout != null) {
		model.addObject("msg", "You have successfully logged out.");
	  }
	  
	  model.setViewName("login.jsp");

	  return model;

	}

}
