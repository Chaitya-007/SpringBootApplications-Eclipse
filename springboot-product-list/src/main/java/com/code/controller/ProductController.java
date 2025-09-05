package com.code.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.entity.Product;
import com.code.exception.ResourceNotFoundException;
import com.code.service.IProductService;
import com.code.service.ProductService;

@RestController
@RequestMapping("/api")

public class ProductController {

	@Autowired
	IProductService productService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World from Springboot Application";
	}

	@GetMapping("/products")
//	@GetMapping(path = "/products", produces = {MediaType.APPLICATION_XML_VALUE})
	public List<Product> getProductList() {
		return productService.findAllProducts();
//		return "This is list";
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable int id) throws ResourceNotFoundException {
		Product product = productService.getProductById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		return product;
	}

	@PostMapping("/product")
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
//		return productService.createProduct(product);
		Map<String, Object> map = new HashMap<String, Object>();
		productService.createProduct(product);
		map.put("status", 1);
		map.put("message", "Record is Saved Successfully!");
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product)throws ResourceNotFoundException {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/product/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
}
