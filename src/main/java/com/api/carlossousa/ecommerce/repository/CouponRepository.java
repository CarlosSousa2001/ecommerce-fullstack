package com.api.carlossousa.ecommerce.repository;

import com.api.carlossousa.ecommerce.model.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, String> {
}
