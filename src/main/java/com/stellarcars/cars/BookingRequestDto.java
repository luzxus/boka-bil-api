package com.stellarcars.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingRequestDto {

    private String carId;
    private String userId;
    private String bookingDate;
    private String bookingTime;
}
