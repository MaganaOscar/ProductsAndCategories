package com.oscar.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oscar.productsandcategories.models.Category;
import com.oscar.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
