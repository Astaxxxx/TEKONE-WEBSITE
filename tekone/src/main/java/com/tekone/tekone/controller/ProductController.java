package com.tekone.tekone.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tekone.tekone.domain.Product;
import com.tekone.tekone.domain.ProductBuilder;

import com.tekone.tekone.domain.Category;

import com.tekone.tekone.service.ProductService;

@Controller
@RequestMapping("/article")
public class ProductController {

	@Autowired
	private ProductService articleService;
	
	@RequestMapping("/add")
	public String addProduct(Model model) {
		Product article = new Product();
		model.addAttribute("article", article);
	
		model.addAttribute("allCategories", articleService.getAllCategories());
		return "addProduct";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("article") Product article, HttpServletRequest request) {
		Product newArticle = new ProductBuilder()
				.withTitle(article.getTitle())
				.stockAvailable(article.getStock())
				.withPrice(article.getPrice())
				.imageLink(article.getPicture())

				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))

				.build();		
		articleService.saveArticle(newArticle);	
		return "redirect:article-list";
	}
	
	@RequestMapping("/article-list")
	public String productList(Model model) {
		List<Product> articles = articleService.findAllArticles();
		model.addAttribute("articles", articles);
		return "productList";
	}

	@RequestMapping("/adminstock")
	public String adminSock(Model model) {
		List<Product> articles = articleService.findAllArticles();
		model.addAttribute("articles", articles);
		return "adminStock";
	}
	

	
	
	@RequestMapping("/edit")
	public String editProduct(@RequestParam("id") Long id, Model model) {
		Product article = articleService.findArticleById(id);
		
		String preselectedCategories = "";
		for (Category category : article.getCategories()) {
			preselectedCategories += (category.getName() + ",");
		}		
		model.addAttribute("article", article);

		model.addAttribute("preselectedCategories", preselectedCategories);

		model.addAttribute("allCategories", articleService.getAllCategories());
		return "editProduct";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editProductPost(@ModelAttribute("article") Product article, HttpServletRequest request) {		
		Product newArticle = new ProductBuilder()
				.withTitle(article.getTitle())
				.stockAvailable(article.getStock())
				.withPrice(article.getPrice())
				.imageLink(article.getPicture())

				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))

				.build();
		newArticle.setId(article.getId());
		articleService.saveArticle(newArticle);	
		return "redirect:article-list";
	}
	
	@RequestMapping("/delete")
	public String deleteArticle(@RequestParam("id") Long id) {
		articleService.deleteArticleById(id);
		return "redirect:article-list";
	}
	
}


