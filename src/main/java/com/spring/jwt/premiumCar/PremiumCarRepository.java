package com.spring.jwt.premiumCar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PremiumCarRepository extends JpaRepository<PremiumCar, Integer> {
    @Query("SELECT MAX(p.premiumCarId) FROM PremiumCar p")
    Optional<Long> findMaxId();

    List<PremiumCar> findByDealerId(Integer dealerId);

    Optional<PremiumCar> findByMainCarId(String mainCarId);
}
