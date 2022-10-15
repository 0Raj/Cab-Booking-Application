package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {

    @Id
    private String carNumberPlate;

    private Integer seatCapacity;

    @OneToOne
    private Driver driver;

    private Double farePerKM;

    @Embedded
    private Location currentLocation;

}
