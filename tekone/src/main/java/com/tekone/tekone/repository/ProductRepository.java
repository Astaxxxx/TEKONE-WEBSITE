package com.tekone.tekone.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tekone.tekone.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	
	@EntityGraph(attributePaths = { "categories" })
	List<Product> findAllEagerBy();	
		
	@EntityGraph(attributePaths = {  "categories" })
	Optional<Product> findById(Long id);
	

	
	@Query("SELECT DISTINCT c.name FROM Category c")
	List<String> findAllCategories();
	
	
	
}
