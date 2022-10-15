package com.thinkify.cabBooking.repository;

import com.thinkify.cabBooking.module.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDAO extends JpaRepository<Driver, String> {

}
