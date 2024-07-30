package com.api.carlossousa.ecommerce.model.dealoftheday;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "deal_of_the_day")
public class DealOfTheDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_price", nullable = false)
    private BigDecimal dealPrice;

    @Column(name = "deal_expiration", nullable = false)
    private LocalDateTime dealExpiration;
    public DealOfTheDay() {
    }

    public DealOfTheDay(Long id, BigDecimal dealPrice, LocalDateTime dealExpiration) {
        this.id = id;
        this.dealPrice = dealPrice;
        this.dealExpiration = dealExpiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public LocalDateTime getDealExpiration() {
        return dealExpiration;
    }

    public void setDealExpiration(LocalDateTime dealExpiration) {
        this.dealExpiration = dealExpiration;
    }
}
