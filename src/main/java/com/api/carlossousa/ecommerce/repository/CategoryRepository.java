package com.api.carlossousa.ecommerce.repository;


import com.api.carlossousa.ecommerce.model.category.Category;
import com.api.carlossousa.ecommerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}