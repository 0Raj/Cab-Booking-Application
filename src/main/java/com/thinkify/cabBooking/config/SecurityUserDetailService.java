package com.thinkify.cabBooking.config;

import com.thinkify.cabBooking.exception.UserNotFoundException;
import com.thinkify.cabBooking.module.SecurityUserDetails;
import com.thinkify.cabBooking.module.User;
import com.thinkify.cabBooking.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userDAO.findById(username);

        if (user.isPresent()){
            return new SecurityUserDetails(user.get());
        }

        throw new UserNotFoundException("Please enter valid user name");
    }
}
