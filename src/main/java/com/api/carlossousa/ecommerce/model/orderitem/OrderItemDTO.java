package com.api.carlossousa.ecommerce.model.orderitem;

import java.math.BigDecimal;

public class OrderItemDTO {
    private Long productId;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String photoUrl;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long productId, String name, BigDecimal price, int quantity, String photoUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.photoUrl = photoUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        this.productId = entity.getProduct().getId();
        this.name = entity.getProduct().getTitle();
        this.price = entity.getProduct().getPrice();
        this.quantity = entity.getQuantity();
        this.photoUrl = entity.getProduct().getPhotoUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
