package com.socialize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocializeController {
	
	@GetMapping("/message")
	public String test() {
		return "Posted";
	}
}
