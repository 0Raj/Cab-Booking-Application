package com.thinkify.cabBooking.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Driver extends User {

    @JsonIgnore
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    private String drivingLicense;

    @JsonIgnore
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Booking> bookingHistory = new ArrayList<>();

    @JsonIgnore
    private Status status;

}
