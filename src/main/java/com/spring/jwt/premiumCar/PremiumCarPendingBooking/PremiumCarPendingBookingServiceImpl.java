package com.spring.jwt.premiumCar.PremiumCarPendingBooking;

import com.spring.jwt.entity.Dealer;
import com.spring.jwt.entity.User;
import com.spring.jwt.premiumCar.PremiumCar;
import com.spring.jwt.premiumCar.PremiumCarRepository;
import com.spring.jwt.repository.DealerRepository;
import com.spring.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumCarPendingBookingServiceImpl implements PremiumCarPendingBookingService {

    @Autowired
    PremiumCarPendingBookingRepository premiumCarPendingBookingRepository;

    @Autowired
    DealerRepository dealerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PremiumCarRepository premiumCarRepository;

    private PremiunCarPendingBookingDto mapToDto(PremiumCarPendingBooking premiumCarPendingBooking) {
        PremiunCarPendingBookingDto dto = new PremiunCarPendingBookingDto();
        dto.setDate(premiumCarPendingBooking.getDate());
        dto.setPrice(premiumCarPendingBooking.getPrice());
        dto.setStatus(premiumCarPendingBooking.getStatus());
        dto.setAskingPrice(premiumCarPendingBooking.getAskingPrice());

        dto.setDealerId(premiumCarPendingBooking.getDealerId() != null ?
                premiumCarPendingBooking.getDealerId(): null);

        dto.setUserId(premiumCarPendingBooking.getUserId() != null ?
                premiumCarPendingBooking.getUserId(): null);

        dto.setPremiumCarId(premiumCarPendingBooking.getPremiumCarCar() != null ?
                premiumCarPendingBooking.getPremiumCarCar().getPremiumCarId() : null);

        return dto;
    }

    private PremiumCarPendingBooking mapToEntity(PremiunCarPendingBookingDto dto) {
        PremiumCarPendingBooking entity = new PremiumCarPendingBooking();
        entity.setDate(dto.getDate());
        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());
        entity.setAskingPrice(dto.getAskingPrice());

        if (dto.getDealerId() != null) {
            Dealer dealer = dealerRepository.findById(dto.getDealerId())
                    .orElseThrow(() -> new RuntimeException("Dealer not found with ID: " + dto.getDealerId()));
            entity.setDealerId(dto.getDealerId());
        }

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
            entity.setUserId(dto.getUserId());
        }

        if (dto.getPremiumCarId() != null) {
            PremiumCar car = premiumCarRepository.findById(dto.getPremiumCarId())
                    .orElseThrow(() -> new RuntimeException("PremiumCar not found with ID: " + dto.getPremiumCarId()));
            entity.setPremiumCarCar(car);
        }

        return entity;
    }



    @Override
    public PremiunCarPendingBookingDto createPremiumCarPendingBookingService(PremiunCarPendingBookingDto premiunCarPendingBookingDto) {
        // 1.Convert DTO to entity
        PremiumCarPendingBooking entity = mapToEntity(premiunCarPendingBookingDto);

        // 2.Save entity
        PremiumCarPendingBooking savedEntity = premiumCarPendingBookingRepository.save(entity);

        //3. Convert saved entity back to DTO and return
        return mapToDto(savedEntity);
    }

}
