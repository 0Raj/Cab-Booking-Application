package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.*;
import java.util.Queue;

@Data
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driverID;

    private Car car;

    private String drivingLicense;

    private Queue<Booking> bookings;


}
