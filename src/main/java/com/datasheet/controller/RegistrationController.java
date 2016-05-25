package com.datasheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.datasheet.model.User;
import com.datasheet.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	UserService userSvc;

	@RequestMapping(params = "register", method = RequestMethod.POST)
	public String registerUser(Model model, @RequestParam("username") String name,
			@RequestParam("password") String password, @RequestParam("email") String email) {

		if ((userSvc.getUserByName(name) == null) && (name != null) && (password != null) && (email != null)) {
			User user = new User(name, password, email);
			userSvc.addUser(user);

			return "redirect:/login";
		} else {
			model.addAttribute("error", "Username is already taken or form blank");
			return "register.jsp";
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "register.jsp";
	}
}
