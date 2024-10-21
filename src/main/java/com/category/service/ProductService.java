package com.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.category.domain.Product;
import com.category.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getAllProducts(Pageable pageable) {
		System.out.println("ProductService::getAllProducts:: pageable " + pageable);
		return productRepository.findAll(pageable);
	}

	public Optional<Product> getProductById(Long id) {
		System.out.println("ProductService::getProductById:: id " + id);
		return productRepository.findById(id);
	}

	public Product createProduct(Product product) {
		System.out.println("ProductService::createProduct:: product " + product);
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product product) {
		System.out.println("ProductService::updateProduct:: product " + product + " id " + id);
		Optional<Product> existingProduct = productRepository.findById(id);
		System.out.println("ProductService::updateProduct:: existingProduct " + existingProduct);
		if (existingProduct.isPresent()) {
			Product updatedProduct = existingProduct.get();
			System.out.println("ProductService::updateProduct:: updatedProduct " + updatedProduct);
			updatedProduct.setName(product.getName());
			updatedProduct.setPrice(product.getPrice());
//			updatedProduct.setCategory(product.getCategory());
			return productRepository.save(updatedProduct);
		}
		return null;
	}

	public void deleteProduct(Long id) {
	    Product product = productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	    System.out.println("ProductService::deleteProduct::id " + id);
	    productRepository.delete(product);
	}

}