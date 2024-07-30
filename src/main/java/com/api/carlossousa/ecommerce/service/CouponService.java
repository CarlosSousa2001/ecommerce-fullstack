package com.api.carlossousa.ecommerce.service;

import com.api.carlossousa.ecommerce.model.coupon.Coupon;
import com.api.carlossousa.ecommerce.model.coupon.CouponDTO;
import com.api.carlossousa.ecommerce.repository.CouponRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        return new CouponDTO(savedCoupon);
    }

    public CouponDTO getCouponByCode(String code) {

        var coupon = couponRepository.findById(code).orElseThrow(
                () -> new EntityNotFoundException()
        );

        return new CouponDTO(coupon);
    }

    public List<CouponDTO> getListCoupon() {
        List<Coupon> coupons = couponRepository.findAll();

        return coupons.stream().map(x -> new CouponDTO(x)).collect(Collectors.toList());
    }

    public void deleteCoupon(String code) {
        couponRepository.deleteById(code);
    }
}
