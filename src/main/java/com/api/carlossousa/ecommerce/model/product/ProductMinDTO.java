package com.api.carlossousa.ecommerce.model.product;

import com.api.carlossousa.ecommerce.model.dealoftheday.DealOfTheDay;

import java.math.BigDecimal;

public class ProductMinDTO {

    private Long id;
    private String title;
    private String shortDescription;
    private BigDecimal price;
    private int quantity;
    private String photoUrl;
    private DealOfTheDay deal;

    public ProductMinDTO() {
    }

    public ProductMinDTO(Long id, String title, String shortDescription, BigDecimal price, int quantity, String photoUrl, DealOfTheDay deal) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.price = price;
        this.quantity = quantity;
        this.photoUrl = photoUrl;
        this.deal = deal;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public DealOfTheDay getDeal() {
        return deal;
    }

    public void setDeal(DealOfTheDay deal) {
        this.deal = deal;
    }
}
