package com.api.carlossousa.ecommerce.repository;


import com.api.carlossousa.ecommerce.model.attribute.Attribute;
import com.api.carlossousa.ecommerce.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {


    Optional<Attribute> findByName(String name);
}
