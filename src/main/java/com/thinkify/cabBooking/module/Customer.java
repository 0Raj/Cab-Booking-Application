package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Data
@Entity

public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings = new ArrayList<>();

}
