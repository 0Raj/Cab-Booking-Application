package com.thinkify.cabBooking.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Car {

    @Id
    private String carNumberPlate;

    private Integer seatCapacity;

    @OneToOne
    @JsonIgnore
    private Driver driver;

    private Double farePerKM;

    @Embedded
    private Location currentLocation;

}
