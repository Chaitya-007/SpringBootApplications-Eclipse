package com.code.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.entity.Order;
import com.code.entity.Product;
import com.code.service.OrderService;
import com.code.service.ProductService;

@RestController
@RequestMapping("/oapi")
public class OrderController {
	@Autowired
	OrderService orderService;

	@Autowired
	ProductService productService;

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable("id") long id) {
	    return orderService.getOrderById(id).get();
	}



	@PostMapping("/orders")
	public ResponseEntity<?> saveOrder(@RequestBody Order order) {
		System.out.println(order.getId() + " " + order.getOrderNumber() + " " + order.getProducts());
		
		
		if (order.getProducts() == null | order.getProducts().isEmpty()) {
			return new ResponseEntity<>("Product List is Emplty", HttpStatus.BAD_REQUEST);
		}
		List<Product> validProducts = new ArrayList<>();
		for (Product p : order.getProducts()) {
			if ((Integer) p.getId() == null) {

				return new ResponseEntity<>("Product Id is Emplty", HttpStatus.BAD_REQUEST);
			}

			Product existingProduct = productService.getProductById(p.getId()).get();

			if (existingProduct == null) {

				return new ResponseEntity<>("Product Id " + p.getId() + " doesn't exist", HttpStatus.BAD_REQUEST);
			}

			validProducts.add(existingProduct);
		}

		order.setProducts(validProducts);
		Order createdOrder = orderService.saveOrder(order);

		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}
}
