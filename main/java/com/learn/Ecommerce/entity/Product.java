package com.learn.Ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Table(name="product_details") will help to change table name
public class Product {
	@Id // to make primary key
	private int productId;
	@Column(nullable = false)  // to change column name
	private String productName;
	@Column(name= "description",nullable = false)
	private String productDescription;
	@Column(nullable = false)
	private int productPrice;
	
	@ManyToOne
	private Category category;
	

}
