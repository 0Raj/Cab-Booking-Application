package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.module.Driver;
import com.thinkify.cabBooking.module.Location;
import com.thinkify.cabBooking.module.UserDTO;

public interface UserService {

    public boolean addUser(UserDTO userDTO);

    public Driver searchRide(Location location);
}
