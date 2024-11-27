package com.learn.Ecommerce.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	
	@Id
	private String category_id;
	@Column(nullable= false)
	private String category_name;
	@Column(nullable = false)
	private String category_desc;
	
	

}
