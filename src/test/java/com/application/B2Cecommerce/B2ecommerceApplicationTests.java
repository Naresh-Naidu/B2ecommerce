package com.application.B2Cecommerce;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.application.B2Cecommerce.controller.BecommerceController;
import com.application.B2Cecommerce.model.Product;
import com.application.B2Cecommerce.service.BecommerceService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class B2ecommerceApplicationTests {

	@Mock
	private BecommerceService service;
	
	@InjectMocks
	private BecommerceController controller;
	
	@Test
	public void getAllProduct() {
		List<Product> list=new ArrayList<>();
		String result="1";
		when(service.getAllProduct()).thenReturn(list);
		assertNotNull(controller.getAllProduct());
	}
	
	@Test
	public void creatProduct() {
		Product product=new Product();
		product.setId(1);
		product.setName("tshirt");
		product.setBrand("Levis");
		product.setColor("red");
		product.setSize(40);
		product.setPrice(2000d);
		
		String result="1";
		when(service.create(product)).thenReturn(result);
		assertEquals(controller.createProduct(product).getBody(), result);
	}

}
