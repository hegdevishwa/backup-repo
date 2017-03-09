package com.sapient.springboot.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BootDemoController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}

	/*@RequestMapping("/")
	public String sayHi() {
		return "Hi";
	}*/

}
