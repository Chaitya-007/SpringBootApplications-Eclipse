package com.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.code.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o JOIN FETCH o.products WHERE o.orderNumber = :orderNumber")
	Order findByOrderNumberWithProducts(@Param("orderNumber") String orderNumber);

	@Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.products")
	List<Order> findAllWithProducts();

}