package com.wellsfargo.fsd.swbd.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.swbd.service.GreetService;

@Controller
public class CommonController {
	
	@Autowired
	private GreetService greetService;
	
	
	@GetMapping({"","/","/home"})
	public String homeAction() {
		
		return "home";
	}
	
	@RequestMapping("/greet")
	public ModelAndView dogreet(@RequestParam("uname") String userName) {
		
		
		return new ModelAndView("home","msg",greetService.greet(userName));
		
	}
	
	@RequestMapping("/header")     //allow GET,POST or any other request by default,because you are not mentioning any request
	public ModelAndView headerAction() {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("header");
		mv.addObject("today",LocalDateTime.now());
		mv.addObject("title", "Spring Boot App");
		
		return mv;
	}

}
