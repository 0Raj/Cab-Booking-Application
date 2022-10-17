package com.thinkify.cabBooking.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Driver extends User {


    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    private String drivingLicense;

    @JsonIgnore
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Booking> bookingHistory = new ArrayList<>();


    private Status status;


    @Override
    public String toString() {
        return "Driver{" +
                "car=" + car +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", bookingHistory=" + bookingHistory +
                ", status=" + status +
                '}';
    }
}
