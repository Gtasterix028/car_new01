package com.spring.jwt.premiumCar.PremiumCarPendingBooking;
import com.spring.jwt.entity.Status;
import com.spring.jwt.premiumCar.PremiumCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PremiunCarPendingBookingDto {

    private LocalDate date;
    private int price;
    private Integer dealerId;
    private Integer userId;
    private Status status;
    private int askingPrice;
    private Integer premiumCarId;



}
