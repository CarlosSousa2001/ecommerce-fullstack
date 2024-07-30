package com.api.carlossousa.ecommerce.service;

import com.api.carlossousa.ecommerce.model.coupon.Coupon;
import com.api.carlossousa.ecommerce.model.coupon.CouponDTO;
import com.api.carlossousa.ecommerce.repository.CouponRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public CouponDTO createCategoryService(CouponDTO couponDTO) {

        Coupon coupon = new Coupon();

        BeanUtils.copyProperties(couponDTO, coupon);

        var savedCoupon  = couponRepository.save(coupon);

        return  new CouponDTO(savedCoupon);
    }
}
