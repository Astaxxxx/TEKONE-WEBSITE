package com.tekone.tekone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekone.tekone.domain.Article;

public interface ArticleService {

	List<Article> findAllArticles();
	
	Page<Article> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, 
			List<String> categories,  String search);

			Page<Article> findArticlesByCriterias(Pageable pageable, List<String> list, String search);
		
	List<Article> findFirstArticles();

	Article findArticleById(Long id);
	
	Article saveArticle(Article article);

	void deleteArticleById(Long id);
	

	List<String> getAllCategories();



}
