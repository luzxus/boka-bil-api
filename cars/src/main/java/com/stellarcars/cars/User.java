package com.stellarcars.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "users")
@Data //takes care of the getter and setters of our instance variables
@AllArgsConstructor //creates a constructor with all the instance variables as arguments
@NoArgsConstructor //creates a constructor with no arguments
public class User {
    @Id
    private ObjectId _id;
    private String name;
    private String userId;
    private String email;
    private String password;
    //@DocumentReference
    private List<String> bookings; //list of bookingIds
}
