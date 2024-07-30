package com.api.carlossousa.ecommerce.model.coupon;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Coupon {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    @Size(max = 20)
    private String code;

    @Min(0)
    @Max(100)
    @Column(name = "percentage", nullable = false)
    private Integer percentage;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "description")
    @Size(max = 75)
    private String description;


    public Coupon() {
    }

    public Coupon(String code, Integer percentage, LocalDate expiryDate, String description) {
        this.code = code;
        this.percentage = percentage;
        this.expiryDate = expiryDate;
        this.description = description;
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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(code, coupon.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
