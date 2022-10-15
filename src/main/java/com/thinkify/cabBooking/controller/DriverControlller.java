package com.thinkify.cabBooking.controller;

import com.thinkify.cabBooking.module.Car;
import com.thinkify.cabBooking.module.CarDTO;
import com.thinkify.cabBooking.module.DriverDTO;
import com.thinkify.cabBooking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverControlller {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody DriverDTO driverDTO){

        driverService.addDriver(driverDTO);
        return new ResponseEntity<>("Driver Added Successfully", HttpStatus.OK);
    }

    @PostMapping("/car")
    public ResponseEntity<String> addUser(@RequestBody CarDTO carDTO){

        driverService.addCar(carDTO);
        return new ResponseEntity<>("Car Added Successfully", HttpStatus.OK);
    }
}
