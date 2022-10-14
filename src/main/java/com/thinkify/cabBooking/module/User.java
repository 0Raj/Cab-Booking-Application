package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    private String mobileNumber;

    @NotNull
    private String name;

    @NotNull
    private String password ;
}
