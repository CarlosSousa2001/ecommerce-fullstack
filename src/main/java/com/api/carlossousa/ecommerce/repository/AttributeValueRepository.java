package com.api.carlossousa.ecommerce.repository;


import com.api.carlossousa.ecommerce.model.attribute.AttributeValue;
import com.api.carlossousa.ecommerce.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {


}
