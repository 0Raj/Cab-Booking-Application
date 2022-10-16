package com.thinkify.cabBooking.module;

import lombok.Data;

@Data
public class LocationDto {

    private Location sourceLocation;

    private Location destination;
}
