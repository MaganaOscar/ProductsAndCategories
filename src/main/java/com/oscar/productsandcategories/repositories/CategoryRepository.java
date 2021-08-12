package com.oscar.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oscar.productsandcategories.models.Category;
import com.oscar.productsandcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
	List<Category> findByProductsNotContains(Product product);
}
