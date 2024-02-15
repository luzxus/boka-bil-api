package com.stellarcars.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping
@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class BookingController {
    @Autowired
    private BookingService _bookingService;


    @GetMapping("/api/v1/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(_bookingService.allBookings(), HttpStatus.OK   );
    }

    @PostMapping("/api/v1/booking")
    public ResponseEntity<Booking> postBooking(@RequestBody BookingRequestDto payload){
        var response = _bookingService.createBooking(payload);
        return new ResponseEntity<Booking>(response, HttpStatus.OK);
    }
}
