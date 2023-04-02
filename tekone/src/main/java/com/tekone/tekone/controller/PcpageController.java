package com.tekone.tekone.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekone.tekone.domain.Article;
import com.tekone.tekone.form.ArticleFilterForm;
import com.tekone.tekone.service.ArticleService;
import com.tekone.tekone.type.SortFilter;

@Controller
public class PcpageController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/pc_Page")
	public String pcpage(@ModelAttribute("filters") ArticleFilterForm filters, Model model) {
		Integer page = filters.getPage();			
		int pagenumber = (page == null ||  page <= 0) ? 0 : page-1;
		SortFilter sortFilter = new SortFilter(filters.getSort());	
		Page<Article> pageresult = articleService.findArticlesByCriterias(PageRequest.of(pagenumber,9, sortFilter.getSortType()), 
																 
		filters.getCategory(),filters.getSearch());	
		model.addAttribute("allCategories", articleService.getAllCategories());
		model.addAttribute("articles", pageresult.getContent());
		model.addAttribute("totalitems", pageresult.getTotalElements());
		model.addAttribute("itemsperpage", 9);
		return "pcPage";
	}

}

