package com.code.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.code.entity.Product;
import com.code.exception.ResourceNotFoundException;
import com.code.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	ProductRepository productRepo;

//	@Override
//	public List<Product> findAllProducts() {
//		ArrayList<Product> productList = new ArrayList<>();
//		productList.add(new Product(1, "Laptop", 50000));
//		productList.add(new Product(2, "Mobile", 10000));
//		productList.add(new Product(3, "Pen", 100));
//		return productList;
//	}
	
	@Override
	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}
	
	public Optional<Product> getProductById(int id) {
		return productRepo.findById(id);
	}

	@Override
	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public ResponseEntity<Product> updateProduct(Integer productId, Product newProduct) throws ResourceNotFoundException{
		 Product product = productRepo.findById(productId)
	        		.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		product.setPname(newProduct.getPname());
		product.setPrice(newProduct.getPrice());
		productRepo.save(product);
		return ResponseEntity.ok(product);
	}
	
    public Map<String, Boolean> deleteProduct (Integer productId){
    	productRepo.deleteById(productId);
    	Map<String, Boolean> map = new HashMap<>();
    	map.put("Deleted Successfully", true);
    	return map;
    }

	

}