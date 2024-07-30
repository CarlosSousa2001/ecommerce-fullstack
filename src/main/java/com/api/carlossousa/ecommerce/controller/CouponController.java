package com.api.carlossousa.ecommerce.controller;

import com.api.carlossousa.ecommerce.exceptions.ResponseMessage;
import com.api.carlossousa.ecommerce.model.category.CategoryDTO;
import com.api.carlossousa.ecommerce.model.coupon.CouponDTO;
import com.api.carlossousa.ecommerce.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/coupon")
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }


    @PostMapping
    public ResponseEntity<CouponDTO> createCoupon(@RequestBody CouponDTO couponDTO) {
        var coupon = couponService.createCategoryService(couponDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CouponDTO> getCouponByCode(@PathVariable String code) {
        var coupon = couponService.getCouponByCode(code);

        return ResponseEntity.ok().body(coupon);
    }

    @GetMapping
    public ResponseEntity<List<CouponDTO>> getListCoupon() {
        List<CouponDTO> couponDTOList = couponService.getListCoupon();

        return ResponseEntity.ok().body(couponDTOList);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<ResponseMessage> deleteCoupon(@PathVariable String code) {
        couponService.deleteCoupon(code);

        ResponseMessage responseMessage = new ResponseMessage("Coupon deletado", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
    }
}
