package com.example.bbs_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BbsController {
	@Autowired
	private BbsService service;
	
	@GetMapping("/messages")
	public String messages(Model model) {
		model.addAttribute("bbsForm", new BbsForm());
		
		
	}
}
