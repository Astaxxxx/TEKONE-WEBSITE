package com.tekone.tekone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.tekone.tekone.domain.Product;
import com.tekone.tekone.form.ProductFilterForm;
import com.tekone.tekone.service.ProductService;
import com.tekone.tekone.type.SortFilter;

@Controller
public class PcpageController {
	
	@Autowired
	private ProductService articleService;
	
	@RequestMapping("/pc_Page")
	public String pcpage(@ModelAttribute("filters") ProductFilterForm filters, Model model) {
		Integer page = filters.getPage();			
		int pagenumber = (page == null ||  page <= 0) ? 0 : page-1;
		SortFilter sortFilter = new SortFilter(filters.getSort());	
		Page<Product> pageresult = articleService.findArticlesByCriterias(PageRequest.of(pagenumber,9, sortFilter.getSortType()), 
																 
		filters.getCategory(),filters.getSearch());	
		model.addAttribute("allCategories", articleService.getAllCategories());
		model.addAttribute("articles", pageresult.getContent());
		model.addAttribute("totalitems", pageresult.getTotalElements());
		model.addAttribute("itemsperpage", 9);
		return "pcPage";
	}

}

