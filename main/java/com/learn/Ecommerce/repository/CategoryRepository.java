package com.learn.Ecommerce.repository;

import com.learn.Ecommerce.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
