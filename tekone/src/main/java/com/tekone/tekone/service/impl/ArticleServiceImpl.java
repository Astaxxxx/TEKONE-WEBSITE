package com.tekone.tekone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tekone.tekone.domain.Article;
import com.tekone.tekone.repository.ArticleRepository;
import com.tekone.tekone.repository.ArticleSpecification;
import com.tekone.tekone.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Value("${articleservice.featured-items-number}")
	private int featuredArticlesNumber;

	@Override
	public List<Article> findAllArticles() {
		return (List<Article>) articleRepository.findAllEagerBy();
	}
	
	@Override
	public Page<Article> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, 
										 List<String> categories,  String search) {		
		Page<Article> page = articleRepository.findAll(ArticleSpecification.filterBy(priceLow, priceHigh, categories,  search), pageable);
        return page;		
	}	

	@Override
	public Page<Article> findArticlesByCriterias(Pageable pageable,List<String> categories, String search) {		
		Page<Article> page = articleRepository.findAll(ArticleSpecification.filterByy(categories,search), pageable);
        return page;		
	}
	
	@Override
	public List<Article> findFirstArticles() {
		return articleRepository.findAll(PageRequest.of(0,featuredArticlesNumber)).getContent(); 
	}

	@Override
	public Article findArticleById(Long id) {
		Optional<Article> opt = articleRepository.findById(id);
		return opt.get();
	}

	@Override
	@CacheEvict(value = {  "categories"}, allEntries = true)
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}
	
	@Override
	@CacheEvict(value = { "categories" }, allEntries = true)
	public void deleteArticleById(Long id) {
		articleRepository.deleteById(id);		
	}

	


	@Override
	@Cacheable("categories")
	public List<String> getAllCategories() {
		return articleRepository.findAllCategories();
	}


}
