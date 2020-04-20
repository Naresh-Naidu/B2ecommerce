package com.application.B2Cecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.B2Cecommerce.exception.ProdctNotFoundException;
import com.application.B2Cecommerce.model.Product;
import com.application.B2Cecommerce.repository.BecommerceRepository;
import java.util.*;

@Component
public class BecommerceService {

	@Autowired
	private BecommerceRepository becommerceRepository;

	public String create(Product product) {
		Product productdb= becommerceRepository.save(product);
		return productdb.getId().toString();
	}

	public Product update(Product product, Integer productId) {

		if (!becommerceRepository.findById(productId).isPresent()) {
			throw new ProdctNotFoundException("product Not exist");
		} else {
			product.setId(productId);
			return becommerceRepository.save(product);
		}
	}

	public List<Product> getAllProduct() {

		return (List<Product>) becommerceRepository.findAll();
	}

	public List<Product> getAllProdcutByBrand(String brand) {

		return becommerceRepository.findByBrand(brand);
	}

	public List<Product> getAllProdcutByColor(String color) {

		return becommerceRepository.findByColor(color);
	}

	public List<Product> getAllProdcutByPrice(Double price) {

		return becommerceRepository.findByPrice(price);
	}
}
