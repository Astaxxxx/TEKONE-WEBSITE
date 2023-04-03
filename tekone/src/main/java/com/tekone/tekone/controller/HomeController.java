package com.tekone.tekone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekone.tekone.domain.Product;
import com.tekone.tekone.service.ProductService;

@Controller
public class HomeController {
		
	@Autowired
	private ProductService articleService;
	
	
	@RequestMapping("/")
	public String index(Model model) {		
		List<Product> articles = articleService.findFirstArticles();
		model.addAttribute("articles", articles);
		return "index";
	}

	
}
