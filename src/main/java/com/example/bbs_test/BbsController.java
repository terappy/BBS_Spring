package com.example.bbs_test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BbsController {
	
	@Autowired
	private BbsService service;
	
	@GetMapping("/bbs")
	public String bbs(Model model) {
		model.addAttribute("bbsForm", new BbsForm());
		
		List<Comment> comments = service.getRecentComment(100);
		model.addAttribute("comments", comments);
		
		return "bbs";
	}
	
	@PostMapping("/bbs")
	public String commentPost(Model model, @Valid BbsForm bbsForm, BindingResult bindingResult, HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			List<Comment> comments = service.getRecentComment(100);
			model.addAttribute("comments", comments);
			return "bbs";
		}
		
		service.save(new Comment(bbsForm.getName(), bbsForm.getComment(), request.getRemoteAddr()));
		return "redirect:/bbs";
	}
}
