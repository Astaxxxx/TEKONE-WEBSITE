package com.tekone.tekone.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductBuilder {
		
	private String title;
	private int stock;	
	private double price;
	private String picture;
	private List<String> categories;
	public ProductBuilder() {
	}
	
	public ProductBuilder withTitle(String title) {
		this.title = title;
		return this;
	}
	
	public ProductBuilder stockAvailable(int stock) {
		this.stock = stock;
		return this;
	}
	
	public ProductBuilder withPrice(double price) {
		this.price = price;
		return this;
	}
	
	public ProductBuilder imageLink(String picture) {
		this.picture = picture;
		return this;
	}
	
	
	
	public ProductBuilder ofCategories(List<String> categories) {
		this.categories = categories;
		return this;
	}
	
	
	
	public Product build() {
		Product article = new Product();
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