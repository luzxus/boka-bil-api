package com.stellarcars.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class UserController {
    @Autowired
    private UserService _userService;


    @GetMapping("/api/v1/users")
    public ResponseEntity<List<User>> getAllBookings(){
        return new ResponseEntity<>(_userService.allUsers(), HttpStatus.OK   );
    }
}
