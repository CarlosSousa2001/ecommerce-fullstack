package com.api.carlossousa.ecommerce.controller;

import com.api.carlossousa.ecommerce.model.category.CategoryDTO;
import com.api.carlossousa.ecommerce.model.coupon.CouponDTO;
import com.api.carlossousa.ecommerce.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/coupon")
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }


    @PostMapping
    public ResponseEntity<CouponDTO> createCategory(@RequestBody CouponDTO couponDTO){
        var coupon = couponService.createCategoryService(couponDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }
}
