package com.thinkify.cabBooking.repository;

import com.thinkify.cabBooking.module.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, String> {

}
