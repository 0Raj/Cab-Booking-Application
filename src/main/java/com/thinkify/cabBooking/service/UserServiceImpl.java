package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.module.Driver;
import com.thinkify.cabBooking.module.Location;
import com.thinkify.cabBooking.module.UserDTO;
import com.thinkify.cabBooking.repository.DriverDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DriverDAO driverDAO;

    @Override
    public boolean addUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public Driver searchRide(Location location) {
        return null;
    }
}
