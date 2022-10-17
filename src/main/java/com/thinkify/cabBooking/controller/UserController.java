package com.thinkify.cabBooking.controller;

import com.thinkify.cabBooking.module.*;
import com.thinkify.cabBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody CustomerDTO customerDTO){
        userService.addUser(customerDTO);
        return new ResponseEntity<>("Customer added successfully", HttpStatus.OK);

    }

    @GetMapping("/search")
    public ResponseEntity<List<Driver>> searchRide(@RequestBody LocationDto locationDto){

        List<Driver> driverList = userService.searchRide(locationDto);

        return new ResponseEntity<>(driverList,HttpStatus.OK);
    }

    @PostMapping("/bookRide/{driverID}")
    public ResponseEntity<Booking> bookRide(@PathVariable("driverID") String driverID,@RequestBody LocationDto locationDto){
        Booking booking = userService.bookRide(driverID,locationDto);
        return new ResponseEntity<>(booking,HttpStatus.OK);
    }
}
