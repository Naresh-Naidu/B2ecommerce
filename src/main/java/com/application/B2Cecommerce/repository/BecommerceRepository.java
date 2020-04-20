package com.application.B2Cecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.B2Cecommerce.model.Product;

@Repository
public interface BecommerceRepository extends CrudRepository<Product, Integer>{

	public List<Product> findByBrand(String brand);
	public List<Product> findByColor(String color);
	
	@Query(value = "select p.* Product p where p.price < ?1", nativeQuery = true)
	public List<Product> findByPrice(Double price);
}
