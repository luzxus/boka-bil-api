package com.stellarcars.cars;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface BookingRepository extends MongoRepository<Booking, ObjectId> {
}
