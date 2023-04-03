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

import com.tekone.tekone.domain.Product;
import com.tekone.tekone.repository.ProductRepository;
import com.tekone.tekone.repository.ProductSpecification;
import com.tekone.tekone.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository articleRepository;
	
	@Value("${articleservice.featured-items-number}")
	private int featuredArticlesNumber;

	@Override
	public List<Product> findAllArticles() {
		return (List<Product>) articleRepository.findAllEagerBy();
	}
	
	@Override
	public Page<Product> findArticlesByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, 
										 List<String> categories,  String search) {		
		Page<Product> page = articleRepository.findAll(ProductSpecification.filterBy(priceLow, priceHigh, categories,  search), pageable);
        return page;		
	}	

	@Override
	public Page<Product> findArticlesByCriterias(Pageable pageable,List<String> categories, String search) {		
		Page<Product> page = articleRepository.findAll(ProductSpecification.filterByy(categories,search), pageable);
        return page;		
	}
	
	@Override
	public List<Product> findFirstArticles() {
		return articleRepository.findAll(PageRequest.of(0,featuredArticlesNumber)).getContent(); 
	}

	@Override
	public Product findArticleById(Long id) {
		Optional<Product> opt = articleRepository.findById(id);
		return opt.get();
	}

	@Override
	@CacheEvict(value = {  "categories"}, allEntries = true)
	public Product saveArticle(Product article) {
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
