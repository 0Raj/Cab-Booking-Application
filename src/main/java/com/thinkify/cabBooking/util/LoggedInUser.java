package com.thinkify.cabBooking.util;

import com.thinkify.cabBooking.exception.UserNotFoundException;
import com.thinkify.cabBooking.module.User;
import com.thinkify.cabBooking.repository.DriverDAO;
import com.thinkify.cabBooking.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoggedInUser {

    private Object principal;

    @Autowired
    private UserDAO userDAO;

    public User getCurrentUser(){
        principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = ((UserDetails) principal).getUsername();

        Optional<User> currentUser = userDAO.findById(username);

        if(currentUser.isPresent()){
            return currentUser.get();
        }

        throw new UserNotFoundException("Please Login First");
    }
}
