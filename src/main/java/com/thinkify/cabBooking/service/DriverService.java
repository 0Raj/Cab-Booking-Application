package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.module.Car;
import com.thinkify.cabBooking.module.CarDTO;
import com.thinkify.cabBooking.module.DriverDTO;

public interface DriverService {
    public void addDriver(DriverDTO driverDTO);

    public void addCar(CarDTO carDTO);

}
