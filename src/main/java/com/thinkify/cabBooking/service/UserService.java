package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.module.*;

import java.util.List;

public interface UserService {

    public boolean addUser(CustomerDTO userDTO);

    public List<Driver> searchRide(LocationDto locationDto);

    public Booking bookRide(String driverID, LocationDto locationDto);
}
