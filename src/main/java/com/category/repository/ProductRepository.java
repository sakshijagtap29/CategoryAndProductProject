package com.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.category.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
