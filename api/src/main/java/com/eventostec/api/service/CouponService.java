package com.eventostec.api.service;

import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.repositories.CouponRepository;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    EventRepository eventRepository;

    public Coupon addCupounToEvent(UUID eventId, CouponRequestDTO coupomData){

        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(coupomData.code());
        coupon.setDiscount(coupomData.discount());
        coupon.setValid(new Date( coupomData.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);

    }
}
