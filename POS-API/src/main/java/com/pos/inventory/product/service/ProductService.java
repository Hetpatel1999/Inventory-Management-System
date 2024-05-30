package com.pos.inventory.product.service;

import java.util.List;
import java.util.Optional;

import com.pos.inventory.product.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Optional<Product> getProductById(String productId);

	public Product saveProduct(Product product);

	public void deleteProduct(String productId);
	
}
