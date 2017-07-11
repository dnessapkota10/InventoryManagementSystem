package com.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/product")
	public String showHello(Model model){		
		model.addAttribute("message","HELLO");		
		return "hello";
	}
}
