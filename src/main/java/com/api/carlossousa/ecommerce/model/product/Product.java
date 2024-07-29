package com.api.carlossousa.ecommerce.model.product;

import com.api.carlossousa.ecommerce.model.attribute.AttributeValue;
import com.api.carlossousa.ecommerce.model.category.Category;
import com.api.carlossousa.ecommerce.model.dealoftheday.DealOfTheDay;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    private Set<Category> categories = new HashSet<>();
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection
    @Size(max = 3)
    @OrderColumn(name = "tag-order")
    private List<String> tags = new ArrayList<>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<AttributeValue> attributes = new HashSet<>();
    @Column(updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant createdAt;
    @OneToOne
    @JoinColumn(name = "deal_id")
    private DealOfTheDay deal;

    public Product() {
    }

    public Product(Long id, String productOwner, String title, String shortDescription, String longDescription, BigDecimal price, int quantity, boolean status, String cod, String photoUrl, double rating) {
        this.id = id;
        this.productOwner = productOwner;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.cod = cod;
        this.photoUrl = photoUrl;
        this.rating = rating;
        this.createdAt = Instant.now();
    }

    public Product(Long id, String title, String shortDescription, String longDescription, BigDecimal price, int quantity, boolean status, String cod, String photoUrl, double rating, Set<Category> categories, List<String> tags, Set<AttributeValue> attributes, DealOfTheDay deal) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.cod = cod;
        this.photoUrl = photoUrl;
        this.rating = rating;
        this.categories = categories;
        this.tags = tags;
        this.attributes = attributes;
        this.createdAt = Instant.now();
        this.deal = deal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<Category> getCategories() {
        return categories;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Set<AttributeValue> getAttributes() {
        return attributes;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    @PostPersist
    public void insertInstantCreated() {
        this.createdAt = Instant.now();
    }


    public DealOfTheDay getDeal() {
        return deal;
    }

    public void setDeal(DealOfTheDay deal) {
        this.deal = deal;
    }
}
