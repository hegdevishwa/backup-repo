package com.vishwa.spring.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	public String greeting(Model model) {
		System.out.println("MyController");
		model.addAttribute("name", "Vishwa");
		return "welcome";
	}

}
