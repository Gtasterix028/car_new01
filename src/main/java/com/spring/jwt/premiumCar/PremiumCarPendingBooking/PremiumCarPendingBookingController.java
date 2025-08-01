package com.spring.jwt.premiumCar.PremiumCarPendingBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PremiumCarPendingBookingController {

    @Autowired
    private PremiumCarPendingBookingService premiumCarPendingBookingService;

    @PostMapping("/create")
    public ResponseEntity createBooking(@RequestBody PremiunCarPendingBookingDto dto) {
        try {
            PremiunCarPendingBookingDto savedBooking = premiumCarPendingBookingService.createPremiumCarPendingBookingService(dto);
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create booking: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
