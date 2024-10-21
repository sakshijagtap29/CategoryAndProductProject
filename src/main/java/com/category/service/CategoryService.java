package com.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category.domain.Category;
import com.category.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Category> getAllCategories(Pageable pageable) {
		System.out.println("CategoryService::getAllCategories::pageable " + pageable);
		return categoryRepository.findAll(pageable);
	}

	public Optional<Category> getCategoryById(Long id) {
		System.out.println("CategoryService::getCategoryById::id " + id);
		return categoryRepository.findById(id);
	}

	public Category createCategory(Category category) {
		System.out.println("CategoryService::getCategoryById::category " + category);
		return categoryRepository.save(category);
	}

	public Category updateCategory(Long id, Category category) {
		System.out.println("CategoryService::updateCategory::id " + id + " Category " + category);
		Optional<Category> existingCategory = categoryRepository.findById(id);
		System.out.println("CategoryService::updateCategory::existingCategory " + existingCategory);
		if (existingCategory.isPresent()) {
			Category updatedCategory = existingCategory.get();
			System.out.println("CategoryService::updateCategory::updatedCategory " + updatedCategory);
			updatedCategory.setName(category.getName());
			return categoryRepository.save(updatedCategory);
		}
		return null;
	}

	public void deleteCategory(Long id) {
		System.out.println("CategoryService::deleteCategory::id " + id);
		categoryRepository.deleteById(id);
	}
}
