package com.tekone.tekone.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticleBuilder {
		
	private String title;
	private int stock;	
	private double price;
	private String picture;
	private List<String> sizes;
	private List<String> categories;
	private List<String> brands;
	
	public ArticleBuilder() {
	}
	
	public ArticleBuilder withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public ArticleBuilder stockAvailable(int stock) {
		this.stock = stock;
		return this;
	}
	
	public ArticleBuilder withPrice(double price) {
		this.price = price;
		return this;
	}
	
	public ArticleBuilder imageLink(String picture) {
		this.picture = picture;
		return this;
	}
	
	
	
	public ArticleBuilder ofCategories(List<String> categories) {
		this.categories = categories;
		return this;
	}
	
	
	
	public Article build() {
		Article article = new Article();
		article.setTitle(this.title);
		article.setPrice(this.price);
		article.setStock(this.stock);
		article.setPicture(this.picture);		
		
		
		
		if (this.categories != null && !this.categories.isEmpty() ) {
			Set<Category> catElements = new HashSet<>();
			for (String val : this.categories) {
				catElements.add(new Category(val,article));
			}
			article.setCategories(catElements);
		}		
		
		
		
		return article;
	}
	
}