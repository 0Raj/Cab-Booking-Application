package com.thinkify.cabBooking.repository;

import com.thinkify.cabBooking.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {
}
