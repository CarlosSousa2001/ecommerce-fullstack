package com.api.carlossousa.ecommerce.model.product;


import com.api.carlossousa.ecommerce.model.attribute.AttributeDTO;
import com.api.carlossousa.ecommerce.model.category.CategoryDTO;
import com.api.carlossousa.ecommerce.model.dealoftheday.DealOfTheDay;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailsDTO {

    private Long id;
    private String productOwner;
    private String title;
    private String shortDescription;
    private String longDescription;
    private BigDecimal price;
    private int quantity;
    private boolean status;
    private String cod;
    private String photoUrl;
    private double rating;
    private Instant createdAt;
    private List<CategoryDTO> categories = new ArrayList<>();
    List<String> tags = new ArrayList<>();
    private List<AttributeDTO> attributes;
    private DealOfTheDay dealOfTheDay;


    public ProductDetailsDTO() {
    }


    public ProductDetailsDTO(Long id, String productOwner, String title, String shortDescription, String longDescription, BigDecimal price, int quantity, boolean status, String cod, String photoUrl, double rating, List<String> tags, List<AttributeDTO> attributes, DealOfTheDay dealOfTheDay) {
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
        this.tags = tags;
        this.attributes = attributes;
        this.dealOfTheDay = dealOfTheDay;
    }

    public ProductDetailsDTO(Product product) {
        this.id = product.getId();
        this.productOwner = product.getProductOwner();
        this.title = product.getProductOwner();
        this.shortDescription = product.getShortDescription();
        this.longDescription = product.getLongDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.status = product.isStatus();
        this.cod = product.getCod();
        this.photoUrl = product.getPhotoUrl();
        this.rating = product.getRating();
        this.createdAt = product.getCreatedAt();
        this.categories = product.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
        this.tags.addAll(product.getTags());
        this.attributes = product.getAttributes().stream().map(x -> new AttributeDTO(x.getId(),x.getAttribute().getName(), x.getValue())).collect(Collectors.toList());
        this.dealOfTheDay = product.getDeal();
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public List<AttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public DealOfTheDay getDealOfTheDay() {
        return dealOfTheDay;
    }

    public void setDealOfTheDay(DealOfTheDay dealOfTheDay) {
        this.dealOfTheDay = dealOfTheDay;
    }
}


