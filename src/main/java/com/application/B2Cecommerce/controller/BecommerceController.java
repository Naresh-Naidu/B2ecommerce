package com.application.B2Cecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.B2Cecommerce.model.Product;
import com.application.B2Cecommerce.service.BecommerceService;

@RestController
@RequestMapping("api/v1/conmmerce/product")

public class BecommerceController {

	
	@Autowired
	private BecommerceService service;
	
	@PostMapping
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product){
		
		return new ResponseEntity<String>(service.create(product), HttpStatus.CREATED);
	}
	
	@PatchMapping("{productId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer productId){
		
		return new ResponseEntity<Product>(service.update(product, productId), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Product>> getAllProduct(){
		
		return new ResponseEntity<List<Product>>(service.getAllProduct(), HttpStatus.OK);
	}
	
	@GetMapping("brandname/{name}")
	public ResponseEntity<List<Product>> getAllByBrand(@PathVariable String name){
		
		return new ResponseEntity<List<Product>>(service.getAllProdcutByBrand(name), HttpStatus.OK);
	}
	
	@GetMapping("colors/{name}")
	public ResponseEntity<List<Product>> getAllByColor(@PathVariable String name){
		
		return new ResponseEntity<List<Product>>(service.getAllProdcutByColor(name), HttpStatus.OK);
	}
	
	@GetMapping("price/{money}")
	public ResponseEntity<List<Product>> getAllByPrice(@PathVariable Double money){
		
		return new ResponseEntity<List<Product>>(service.getAllProdcutByPrice(money), HttpStatus.OK);
	}
}
