package com.thinkify.cabBooking.module;

import lombok.Data;

@Data
public class CarDTO {
    private String carNumberPlate;

    private Integer seatCapacity;

    private Double farePerKM;

    private Location currentLocation;
}
