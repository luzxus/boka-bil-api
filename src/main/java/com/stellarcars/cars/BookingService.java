package com.stellarcars.cars;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired //instantiate this class so we can use it
    private BookingRepository _bookingRepository;
    @Autowired
    private MongoTemplate _mongoTemplate;
    public List<Booking> allBookings(){
        //inside bookingRepositry we have specified that it is of type Booking. the findAll method knows this now and the built-in method findAll() will return all booking objects
        return _bookingRepository.findAll();
    }

    public Booking createBooking(BookingRequestDto payload){
        String newBookingId = generateNewBookingId();

        // Create a new Booking object
        Booking booking = new Booking();
        booking.setBookingId(newBookingId);
    booking.setBookingDate(payload.getBookingDate());
    booking.setBookingTime(payload.getBookingTime());
    booking.setCarId(payload.getCarId());
    booking.setUserId(payload.getUserId());
    booking.setStatus("confirmed");


//        var bookingObj = new Object() {
//            String bookingId = booking.getBookingId();
//        };

    _bookingRepository.insert(booking);
        _mongoTemplate.update(User.class)
                .matching(Criteria.where("userId").is(payload.getUserId()))
                .apply(new Update().push("bookings", new Document("bookingId", newBookingId)))
                .first();

    return booking;
    }

    // Method to generate a new unique bookingId
    private String generateNewBookingId() {
        Optional<Booking> latestBooking = _mongoTemplate.find(
                new Query().with(Sort.by(Sort.Direction.DESC, "bookingId")).limit(1),
                Booking.class
        ).stream().findFirst();

        // Increment the latest bookingId by one
        String newBookingId;
        if (latestBooking.isPresent()) {
            int latestBookingId = Integer.parseInt(latestBooking.get().getBookingId());
            newBookingId = String.valueOf(latestBookingId + 1);
        } else {
            // If no bookings exist, start with bookingId 1
            newBookingId = "1";
        }
        return newBookingId;
    }
}
