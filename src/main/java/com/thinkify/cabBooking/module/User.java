package com.thinkify.cabBooking.module;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
     @Id
     private String mobileNumber;

     @NotNull
     private String name;

     @NotNull
     private Gender gender;

     @NotNull
     private Integer age;

     @NotNull
     private String password;

     private String role;


}
