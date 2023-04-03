package com.tekone.tekone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekone.tekone.domain.Product;

public interface ProductService {

	List<Product> findAllArticles();
	
	Page<Product> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, 
			List<String> categories,  String search);

			Page<Product> findArticlesByCriterias(Pageable pageable, List<String> list, String search);
		
	List<Product> findFirstArticles();

	Product findArticleById(Long id);
	
	Product saveArticle(Product article);

	void deleteArticleById(Long id);
	

	List<String> getAllCategories();



}
