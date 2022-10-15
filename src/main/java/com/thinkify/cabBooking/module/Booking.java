package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingID;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Driver driver;

    private LocalDateTime timeStamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "lattitude",column = @Column(name = "sorce_latitude")),
            @AttributeOverride(name = "longitude",column = @Column(name = "sorce_longitude"))
    })
    private Location sourceLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "lattitude",column = @Column(name = "destination_latitude")),
            @AttributeOverride(name = "longitude",column = @Column(name = "destination_longitude"))
    })
    private Location destination;

    private Double billAmount;

}
