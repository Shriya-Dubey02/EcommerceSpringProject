package com.learn.Ecommerce.repository;

import com.learn.Ecommerce.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category, String> {

}
