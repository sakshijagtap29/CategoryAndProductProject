package com.category.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.category.domain.Category;
import com.category.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAllData")
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
    	System.out.println("CategoryController::getAllCategories::page " + page);
        return categoryService.getAllCategories(PageRequest.of(page, 10));
    }

    @GetMapping("/getAllData/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
    	System.out.println("CategoryController::getCategoryById::id " + id);
        return categoryService.getCategoryById(id);
    }

//    @PostMapping("/save")
//    public Category createCategory(@RequestBody Category category) {
//    	System.out.println("CategoryController::createCategory::category " + category);
//        return categoryService.createCategory(category);
//    }
    
    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
    	System.out.println("CategoryController::createCategory::category " + category);
        Category savedCategory = categoryService.createCategory(category);
        System.out.println("CategoryController::createCategory::savedCategory " + savedCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/putData/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
    	System.out.println("CategoryController::updateCategory::category " + category +  " id " + id);
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	System.out.println("CategoryController::deleteCategory::id " + id );
        categoryService.deleteCategory(id);
    }
}

