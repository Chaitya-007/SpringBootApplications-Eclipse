package com.code.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.code.entity.Product;
import com.code.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductRepository productRepo;
	
//	@Override
//	public List<Product> findAllProducts() {
//		// TODO Auto-generated method stub
//		List<Product> productList = new ArrayList<>();
//		productList.add(new Product(1,"Phone", 20000));
//		productList.add(new Product(2,"Laptop", 60000));
//		productList.add(new Product(3,"Computer", 80000));
//		productList.add(new Product(4,"Charger", 200));
//		return productList;
//	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
	public Optional<Product> getProductById(int id) {
		return productRepo.findById(id);
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public ResponseEntity<Product> updateProduct(Integer productId, Product newProduct) {
		// TODO Auto-generated method stub
		Product product = productRepo.findById(productId).get();
		product.setPname(newProduct.getPname());
		product.setPrice(newProduct.getPrice());
		productRepo.save(product);
		return ResponseEntity.ok(product);
	}

	@Override
	public Map<String, Boolean> deleteProduct (Integer productId){
    	productRepo.deleteById(productId);
    	Map<String, Boolean> map = new HashMap<>();
    	map.put("Deleted Successfully", true);
    	return map;
    }
}
