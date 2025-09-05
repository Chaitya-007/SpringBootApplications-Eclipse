package com.code.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dto.Product;
import com.code.entity.Order;
import com.code.exception.ResourceNotFoundException;
import com.code.feign.ProductClient;
//import com.code.repository.ProductRepository;
import com.code.service.OrderService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/oapi")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	ProductClient productClient;

	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public List<Order> getAllOrder() {
		log.info("Get All the order called");
		return orderService.getAllOrder();
	}

//	@GetMapping("/orders/{id}")
//	public Order getOrderById(@PathVariable long id) {
//		return orderService.getOrderById(id).get();
//	}

	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable Long id) throws ResourceNotFoundException {
		log.warn("Be careful while entering the existing order id");
		log.error("Error in Get orders");
		return orderService.getOrderById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
	}

	@PostMapping("/orders")
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}

	@GetMapping("/orders/products")
	public List<Product> getProductsFromProductService() {
		return productClient.getAllProducts();
	}

	@GetMapping("/orders/products/{id}")
	public Product getProductById(@PathVariable() int id) {
		return productClient.getProductById(id);
	}

}
