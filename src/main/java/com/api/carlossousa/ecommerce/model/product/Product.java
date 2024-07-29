package com.api.carlossousa.ecommerce.model.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productOwner;
    @Column(name = "title", nullable = false)
    @Size(min = 2, max = 100)
    private String title;
    @Column(name = "short_description")
    @Size(max = 156)
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;
    private BigDecimal price;
    private int quantity;
    private boolean status;
    @Column(nullable = false, length = 50, unique = true)
    private String cod;
    @URL
    @Column(name = "photo_url")
    @Size(max = 225)
    private String photoUrl;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    private double rating = 0.0;
}
