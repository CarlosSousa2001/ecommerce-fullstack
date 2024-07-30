package com.api.carlossousa.ecommerce.model.product;

import com.api.carlossousa.ecommerce.model.attribute.AttributeDTO;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDTO {

    private Long id;
    private String title;
    private String shortDescription;
    private String longDescription;
    private BigDecimal price;
    private int quantity;
    private String cod;
    private String photoUrl;
    private List<Long> categoryIds;
    private List<String> tags;
    private List<AttributeDTO> attributes;


    public ProductRequestDTO() {
    }

    public ProductRequestDTO(Long id, String title, String shortDescription, String longDescription, BigDecimal price, int quantity, String cod, String photoUrl, List<Long> categoryIds, List<String> tags, List<AttributeDTO> attributes) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.price = price;
        this.quantity = quantity;
        this.cod = cod;
        this.photoUrl = photoUrl;
        this.categoryIds = categoryIds;
        this.tags = tags;
        this.attributes = attributes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<AttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDTO> attributes) {
        this.attributes = attributes;
    }
}
