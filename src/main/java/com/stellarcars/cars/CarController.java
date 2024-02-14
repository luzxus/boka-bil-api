package com.stellarcars.cars;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    @Autowired
    private CarService _carService;
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        try{
           var cars = _carService.allCars();
           if(cars.isEmpty()){
               return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
           }else{
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
           }
        }catch (Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCar(@PathVariable String id){
        try{
            var car = _carService.singleCar(id);
            if(car.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<Optional<Car>>(car, HttpStatus.OK);
            }
        }catch (Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }
}
