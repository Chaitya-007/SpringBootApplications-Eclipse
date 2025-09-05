package com.code.springboot_hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.code.entity.Product;
import com.code.repository.ProductRepository;
import com.code.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepo;

	@InjectMocks
	private ProductService productService;

	@Test
	public void testgetAllProducts() {
		Product laptop = new Product(12, "hp", 7500);
		Product phone = new Product(13, "moto", 700);
		when(productRepo.findAll()).thenReturn(Arrays.asList(laptop, phone));
		List<Product> products = productService.findAllProducts();
		assertEquals(2, products.size());
		assertEquals("hp", products.get(0).getPname());
		verify(productRepo, times(1)).findAll();
	}

	@Test
	void testGetProductById_Found() {
		Product laptop = new Product(67, "Laptop", 5000);
		when(productRepo.findById(67)).thenReturn(Optional.of(laptop));

		Product result = productService.getProductById(67).get();
		assertNotNull(result);
		assertEquals("Laptop", result.getPname());
		verify(productRepo, times(1)).findById(67);
	}
	
	  @Test
	    void testGetProductById_NotFound() {
	        when(productRepo.findById(99)).thenReturn(Optional.empty());

	        Optional<Product> result = productService.getProductById(99);

	        assertNotNull(result.isEmpty());
	        verify(productRepo, times(1)).findById(99);
	    }

}
