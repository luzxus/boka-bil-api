package com.stellarcars.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired //instantiate this class so we can use it
    private UserRepository _userRepository;
    public List<User> allUsers(){
        return _userRepository.findAll();
    }
}
