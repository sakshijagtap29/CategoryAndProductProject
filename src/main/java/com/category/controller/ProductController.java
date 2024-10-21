package com.category.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.category.domain.Product;
import com.category.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProducts")
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
		System.out.println("ProductController::getAllProducts::page " + page);
		return productService.getAllProducts(PageRequest.of(page, 10));
	}

	@GetMapping("/getProductById/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		System.out.println("ProductController::getProductById::id " + id);
		return productService.getProductById(id);
	}

	@PostMapping("/save")
	public Product createProduct(@RequestBody Product product) {
		System.out.println("ProductController::createProduct::product " + product);
		return productService.createProduct(product);
	}

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		System.out.println("ProductController::updateProduct::product " + product + " id " + id);
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) {
		System.out.println("ProductController::deleteProduct::id " + id);
		productService.deleteProduct(id);
	}
}
