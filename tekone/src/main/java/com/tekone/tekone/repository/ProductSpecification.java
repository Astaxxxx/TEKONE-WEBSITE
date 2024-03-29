package com.tekone.tekone.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.tekone.tekone.domain.Product;

import com.tekone.tekone.domain.Category;


public class ProductSpecification {
	
	private ProductSpecification() {}
	
	@SuppressWarnings("serial")
	public static Specification<Product> filterBy(Integer priceLow, Integer priceHigh, 
												  List<String> categories,  String search) {			
		return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();                
                query.distinct(true);                
                
                if (categories!=null && !categories.isEmpty()) {
                	Join<Product, Category> joinSize = root.join("categories");
                	predicates.add(criteriaBuilder.and(joinSize.get("name").in(categories)));
                }   
                 
                
                if(search!=null && !search.isEmpty()) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%"+search+"%")));
                }
                if (priceLow!=null && priceLow >= 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), priceLow)));
                }
                if (priceHigh!=null && priceHigh >= 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), priceHigh)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };		
	}

    public static Specification<Product> filterByy( List<String> categories, String search) {
        return null;
    }
}
