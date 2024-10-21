package com.category.domain;

import javax.persistence.*;

@Entity(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "product_name")
	private String name;
	@Column(name = "product_price")
	private double price;

//	public Product(Long id, String name, double price, Category category) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.category = category;
//	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}

}
