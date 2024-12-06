package com.learn.Ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learn.Ecommerce.entity.Product;
import com.learn.Ecommerce.productProjection.ProductProjection;


@RepositoryRestResource(excerptProjection = ProductProjection.class)
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByProductPriceGreaterThan(int price);
	
	List<Product> findByProductPriceLessThan(int price);
	
	List<Product> findByProductPriceLessThanEqual(int price);
	
	List<Product> findByProductPriceBetween(int startPrice,int endPrice);
	
	List<Product> findByProductNameStartingWith(String pname);
	
	

}
