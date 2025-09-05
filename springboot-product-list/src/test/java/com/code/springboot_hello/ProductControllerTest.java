package com.code.springboot_hello;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.code.controller.ProductController;
import com.code.entity.Product;
import com.code.service.ProductService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	@Test
	public void testGetAllProducts() throws Exception
	{
		List<Product> products = Arrays.asList(
				new Product(1, "Lenovo", 80000),
				new Product(2, "Santoor", 8800));
		Mockito.when(productService.findAllProducts()).thenReturn(products);
        mockMvc.perform(get("/api/products"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].pname", is("Lenovo")));
	}
	
	@Test
	public void testProductById() throws Exception {
		Product product=new Product(1,"Mouse",1200);
        when(productService.getProductById(1)).thenReturn(Optional.of(product));
 
        Product result = productService.getProductById(1).get();
        mockMvc.perform(get("/api/products/1")) .andExpect(status().isOk())
        .andExpect(jsonPath("$.pName", is("Mouse"))).andExpect(jsonPath("$.price", is(1200)));
	}

}
