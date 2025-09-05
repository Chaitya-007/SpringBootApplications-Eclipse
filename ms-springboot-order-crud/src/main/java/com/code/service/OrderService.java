package com.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.entity.Order;
import com.code.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	
	public List<Order> getAllOrder(){
		return orderRepo.findAll();
	}
	
	public Optional<Order> getOrderById(long id) {
		return orderRepo.findById(id);
	}
	
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
}
