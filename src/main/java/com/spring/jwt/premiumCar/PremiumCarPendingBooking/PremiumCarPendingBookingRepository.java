package com.spring.jwt.premiumCar.PremiumCarPendingBooking;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumCarPendingBookingRepository extends JpaRepository<PremiumCarPendingBooking, Long> {
}
