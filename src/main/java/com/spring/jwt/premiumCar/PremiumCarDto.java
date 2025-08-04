package com.spring.jwt.premiumCar;

import com.spring.jwt.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PremiumCarDto{

    private Integer premiumCarId;
    private Boolean airbag;
    private Boolean ABS;
    private Boolean buttonStart;
    private Boolean sunroof;
    private Boolean childSafetyLocks;
    private Boolean acFeature;
    private Boolean musicFeature;
    private String area;
    private String variant;
    private String brand;
    private Boolean carInsurance;
    private String carInsuranceDate;
    private String carInsuranceType;
    private Status carStatus;
    private boolean pendingApproval;
    private String city;
    private String color;
    private String description;
    private String fuelType;
    private Integer kmDriven;
    private String model;
    private Integer ownerSerial;
    private Boolean powerWindowFeature;
    private Integer price;
    private Boolean rearParkingCameraFeature;
    private String registration;
    private String title;
    private String transmission;
    private Integer year;
    private LocalDate date;
    private Integer dealerId;
    private long carPhotoId;
    private String mainCarId;
    private String carType;

    private Set<Long> premiumCarPendingBookingId; // Representing PendingBooking as just IDs for simplification


    public PremiumCarDto(PremiumCar car) {
    }
}
