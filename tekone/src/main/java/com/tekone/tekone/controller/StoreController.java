package com.tekone.tekone.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekone.tekone.domain.Product;
import com.tekone.tekone.form.ProductFilterForm;
import com.tekone.tekone.service.ProductService;
import com.tekone.tekone.type.SortFilter;

@Controller
public class StoreController {
	
	@Autowired
	private ProductService articleService;
	
	@RequestMapping("/store")
	public String store(@ModelAttribute("filters") ProductFilterForm filters, Model model) {
		Integer page = filters.getPage();			
		int pagenumber = (page == null ||  page <= 0) ? 0 : page-1;
		SortFilter sortFilter = new SortFilter(filters.getSort());	
		Page<Product> pageresult = articleService.findArticlesByCriteria(PageRequest.of(pagenumber,9, sortFilter.getSortType()), 
																filters.getPricelow(), filters.getPricehigh(), 
																 filters.getCategory(), filters.getSearch());	
		model.addAttribute("allCategories", articleService.getAllCategories());
	
		model.addAttribute("articles", pageresult.getContent());
		model.addAttribute("totalitems", pageresult.getTotalElements());
		model.addAttribute("itemsperpage", 9);
		return "store";
	}
	
	
	@RequestMapping("/article-detail")
	public String productDetail(@PathParam("id") Long id, Model model) {
		Product article = articleService.findArticleById(id);
		model.addAttribute("article", article);
		model.addAttribute("notEnoughStock", model.asMap().get("notEnoughStock"));
		model.addAttribute("addProductSuccess", model.asMap().get("addProductSuccess"));
		return "productDetail";
	}
	

}
