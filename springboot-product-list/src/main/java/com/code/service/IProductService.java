package com.code.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.code.entity.Product;
import com.code.exception.ResourceNotFoundException;

public interface IProductService {
	
	public List<Product> findAllProducts();
	Optional<Product> getProductById(int id);
	Product createProduct(Product product);
	ResponseEntity<Product> updateProduct(Integer productId, Product productDetails) throws ResourceNotFoundException;
	Map<String, Boolean> deleteProduct (Integer productId);
}
