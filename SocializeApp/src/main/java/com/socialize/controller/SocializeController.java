package com.socialize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocializeController {
	
	@RequestMapping("/message")
	public String test() {
		return "Posted";
	}
}
