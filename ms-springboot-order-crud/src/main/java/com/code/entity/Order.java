package com.code.entity;

//import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order6")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String orderNumber;
	
	public Order(Long id, String orderNumber) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
