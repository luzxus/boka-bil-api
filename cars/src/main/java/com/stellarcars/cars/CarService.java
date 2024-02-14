package com.stellarcars.cars;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired //instantiate this class so we can use it
    private CarRepository _carRepository;
    public List<Car> allCars(){
        //inside carrepositry we have specified that it is of type Car. the findAll method knows this now and the built-in method findAll() will return all car objects
        return _carRepository.findAll();
    }

    public Optional<Car> singleCar(String id){ //Optional<Car> means that it may not find the Car object and then we will return null
        return _carRepository.findByCarId(id);
    }

    public Optional<Car> singleCar(ObjectId id){ //find the entry by ObjectId instead of carId
        return _carRepository.findById(id);
    }
}
