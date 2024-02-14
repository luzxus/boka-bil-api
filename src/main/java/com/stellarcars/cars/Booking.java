package com.stellarcars.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document(collection = "bookings")
@AllArgsConstructor
@Data
public class Booking {
    @Id
    private ObjectId _id;
    private String bookingId;
    private String carId;
    private String userId;
    private String bookingDate;
    private String bookingTime;
    private String status;
}
