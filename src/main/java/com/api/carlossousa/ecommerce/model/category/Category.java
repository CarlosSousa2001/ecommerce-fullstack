package com.api.carlossousa.ecommerce.model.category;

import jakarta.persistence.*;

import java.time.Instant;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    @Column(updatable = false)
    private Instant createdAt;

    public Category() {
    }

    public Category(Long id, String category) {
        this.id = id;
        this.category = category;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}