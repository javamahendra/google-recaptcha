package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.domain.User;
import com.app.service.IUserService;
import com.app.validator.Validator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
@RequestMapping("/user")
public class UserController{
	
	@Autowired
	private IUserService userService;
	@Autowired
	private Validator validator;
	@GetMapping("/register")
	public String userRegister(Model model){
		
		model.addAttribute("user", new User());
		return "userRegister";
	}
	
	@PostMapping("/create")
	public String createRegister(@ModelAttribute("user") User user,
			@RequestParam("g-recaptcha-response") String captcha, Model model) throws JsonMappingException, JsonProcessingException, UnirestException{
		String msg = null;
		if(validator.validateRecaptcha(captcha)) {
			Long id = userService.createUser(user);
			model.addAttribute("user", new User());
			msg =  "Saved '"+id+"' user";
		}else {
			msg = "invalid recaptcha";	
		}
		
		model.addAttribute("msg",msg);			
		
		return "userRegister";
	}
	
	@GetMapping("/all")
	public String getAllUsers(Model model){
		model.addAttribute("users", userService.getAllUsers());
		return "usersData";
	}
}
