package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.module.Booking;
import com.thinkify.cabBooking.module.Driver;
import com.thinkify.cabBooking.module.CustomerDTO;
import com.thinkify.cabBooking.module.LocationDto;
import com.thinkify.cabBooking.repository.DriverDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DriverDAO driverDAO;

    @Override
    public boolean addUser(CustomerDTO userDTO) {
        return false;
    }

    @Override
    public List<Driver> searchRide(LocationDto locationDto) {
        return null;
    }

    @Override
    public Booking bookRide(Driver driver, LocationDto locationDto) {
        return null;
    }
}
