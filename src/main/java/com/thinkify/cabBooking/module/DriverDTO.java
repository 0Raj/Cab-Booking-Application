package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DriverDTO {

    private String mobileNumber;

    private String name;

    private String gender;

    private Integer age;

    private String password;

    private String drivingLicense;
}
