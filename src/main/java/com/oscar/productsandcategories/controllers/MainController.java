package com.oscar.productsandcategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.productsandcategories.models.Category;
import com.oscar.productsandcategories.models.Product;
import com.oscar.productsandcategories.services.MainService;

@Controller
public class MainController {
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, BindingResult result) {
		return "newProduct.jsp";
	}
	
	@RequestMapping(value="/products/create", method=RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") Product product, BindingResult result) {
		mainService.createProduct(product);
		return "redirect:/products/new";
	}
	
	@RequestMapping(value="/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, BindingResult result) {
		return "newCategory.jsp";
	}
	
	@RequestMapping(value="/categories/create")
	public String createCategory(@ModelAttribute("category") Category category, BindingResult result) {
		mainService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = mainService.getProduct(id);
		List<Category> categories = mainService.findCategoriesNotContainingProduct(product);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "showProduct.jsp";
	}
	
	@RequestMapping(value="/products/add", method=RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("product") Long id, @RequestParam("category") Long catID) {
		Product product = mainService.getProduct(id);
		Category category = mainService.getCategory(catID);
		mainService.addCategoryToProduct(product, category);
		return "redirect:/products/" + id;
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = mainService.getCategory(id);
		List<Product> products = mainService.findProductsNotContainingCategory(category);
		model.addAttribute("products", products);
		model.addAttribute("category", category);
		return "showCategory.jsp";
	}
	
	@RequestMapping(value="/categories/add", method=RequestMethod.POST)
	public String addProductToCategory(@RequestParam("category") Long id, @RequestParam("product") Long productID) {
		Category category = mainService.getCategory(id);
		Product product = mainService.getProduct(productID);
		mainService.addProductToCategory(category, product);
		return "redirect:/categories/" + id;
	}
	
}
