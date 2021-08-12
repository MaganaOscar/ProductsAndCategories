package com.oscar.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oscar.productsandcategories.models.Category;
import com.oscar.productsandcategories.models.Product;
import com.oscar.productsandcategories.repositories.CategoryRepository;
import com.oscar.productsandcategories.repositories.ProductRepository;

@Service
public class MainService {
	private final CategoryRepository catRepo;
	private final ProductRepository proRepo;
	
	public MainService(CategoryRepository catRepo, ProductRepository proRepo) {
		this.catRepo = catRepo;
		this.proRepo = proRepo;
	}
	
	public Product createProduct(Product product) {
		return proRepo.save(product);
	}
	
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}
	
	public Category getCategory(Long id) {
		Optional<Category> optionalCategory = catRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public Product getProduct(Long id) {
		Optional<Product> optionalProduct = proRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public List<Product> getProducts() {
		return proRepo.findAll();
	}
	
	public List<Category> getCategories() {
		return catRepo.findAll();
	}
	
	public Product addCategoryToProduct(Product product, Category category) {
		product.getCategories().add(category);
		return proRepo.save(product);
	}
	
	public Category addProductToCategory(Category category, Product product) {
		category.getProducts().add(product);
		return catRepo.save(category);
	}
	
	public List<Category> findCategoriesNotContainingProduct(Product product) {
		return catRepo.findByProductsNotContains(product);
	}
	
	public List<Product> findProductsNotContainingCategory(Category category) {
		return proRepo.findByCategoriesNotContains(category);
	}
}
