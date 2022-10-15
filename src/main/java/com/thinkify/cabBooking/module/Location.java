package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Location {

    private Float lattitude;

    private Float longitude;
}
