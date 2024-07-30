package com.api.carlossousa.ecommerce.model.coupon;

import java.time.LocalDate;

public class CouponDTO {

    private String code;
    private Integer percentage;
    private LocalDate expiryDate;
    private String description;

    public CouponDTO() {
    }

    public CouponDTO(String code, Integer percentage, LocalDate expiryDate, String description) {
        this.code = code;
        this.percentage = percentage;
        this.expiryDate = expiryDate;
        this.description = description;
    }

    public CouponDTO(Coupon coupon) {
        this.code = coupon.getCode();
        this.percentage = coupon.getPercentage();
        this.expiryDate = coupon.getExpiryDate();
        this.description = coupon.getDescription();
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
